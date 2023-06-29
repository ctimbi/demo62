package ec.edu.ups.demo62.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Factura {

	@Id
	@GeneratedValue
	@Column(name="fac_codigo")
	private int codigo;
	
	@Column(name="fac_numero")
	private String numero;
	
	@Column(name="fac_fecha")
	private Date fecha;
	
	@OneToOne
	@JoinColumn(name="per_cedula")
	private Persona cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fac_codigo")
	private List<DetalleFactura> detalles;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}	
	
	public void addDetalle(DetalleFactura detalle) {
		if(detalles == null) {
			detalles = new ArrayList<DetalleFactura>();
		}
		detalles.add(detalle);
		
	}

	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente
				+ ", detalles=" + detalles + "]";
	}
	
}
