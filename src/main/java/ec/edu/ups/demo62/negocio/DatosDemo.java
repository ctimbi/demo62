package ec.edu.ups.demo62.negocio;

import ec.edu.ups.demo62.datos.PersonaDAO;
import ec.edu.ups.demo62.modelo.Persona;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private PersonaDAO daoPersona;
	
	@PostConstruct
	public void init() {
		System.out.println("Hola UPS");
		
		Persona p = new Persona();
		p.setCedula("0103709911");
		p.setDireccion("Monay");
		p.setNombre("Cristian Timbi");
		
		daoPersona.insert(p);
	}
}
