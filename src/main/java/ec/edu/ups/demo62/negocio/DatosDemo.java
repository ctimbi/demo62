package ec.edu.ups.demo62.negocio;

import java.util.Date;
import java.util.List;

import ec.edu.ups.demo62.datos.DetalleFacturaDAO;
import ec.edu.ups.demo62.datos.FacturaDAO;
import ec.edu.ups.demo62.datos.PersonaDAO;
import ec.edu.ups.demo62.datos.ProductoDAO;
import ec.edu.ups.demo62.modelo.DetalleFactura;
import ec.edu.ups.demo62.modelo.Factura;
import ec.edu.ups.demo62.modelo.Persona;
import ec.edu.ups.demo62.modelo.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private PersonaDAO daoPersona;
	
	@Inject
	private ProductoDAO daoProducto;
	
	@Inject
	private FacturaDAO daoFactura;
	
	@Inject
	private DetalleFacturaDAO daoDetalle;
	
	@PostConstruct
	public void init() {
		System.out.println("Hola UPS");
		
		Persona p = new Persona();
		p.setCedula("0103709911");
		p.setDireccion("Monay");
		p.setNombre("Cristian Timbi");
		daoPersona.insert(p);
		
		Producto pro1 = new Producto();
		pro1.setNombre("TV Sony");
		pro1.setPrecio(450.00);
		pro1.setStock(10);
		daoProducto.insert(pro1);
		
		Producto pro2 = new Producto();
		pro2.setNombre("Lavadora Mabe");
		pro2.setPrecio(400.00);
		pro2.setStock(10);
		daoProducto.insert(pro2);
		
		Producto pro3 = new Producto();
		pro3.setNombre("Licuadora Oster");
		pro3.setPrecio(40.00);
		pro3.setStock(20);
		daoProducto.insert(pro3);
		
		Factura fac = new Factura();
		fac.setNumero("001-001-000001");
		fac.setFecha(new Date());
		fac.setCliente(p);
		
		DetalleFactura det1 = new DetalleFactura();
		det1.setProducto(pro1);
		det1.setCantidad(1);
		det1.setPrecio(450);
		
		//daoDetalle.insert(det1);
		
		fac.addDetalle(det1);
		
		DetalleFactura det2 = new DetalleFactura();
		det2.setProducto(pro3);
		det2.setCantidad(2);
		det2.setPrecio(400);
		//daoDetalle.insert(det2);
		
		fac.addDetalle(det2);
		
		daoFactura.insert(fac);
		
		List<Producto> productos = daoProducto.getAll();
		for(Producto pro: productos) {
			System.out.println(pro);
		}
		
		List<Factura> facturas = daoFactura.getAll();
		for(Factura fact: facturas) {
			System.out.println(fact.getCodigo() + ": " + fact.getNumero() + "- " + fac.getCliente().getNombre() + 
					" total productos: " + fac.getDetalles().size());
		}
		
	}
}
