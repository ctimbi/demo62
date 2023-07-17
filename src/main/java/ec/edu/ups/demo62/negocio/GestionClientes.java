package ec.edu.ups.demo62.negocio;

import java.util.List;

import ec.edu.ups.demo62.datos.PersonaDAO;
import ec.edu.ups.demo62.modelo.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {

	@Inject
	private PersonaDAO daoPersona;
	
	public void guardarClientes(Persona persona) throws Exception {
		if(!this.isCedulaValida(persona.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoPersona.read(persona.getCedula()) == null) {
			try {
				daoPersona.insert(persona);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoPersona.update(persona);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		return cedula.length() == 10;
	}
	
	public void guardarClientes(String cedula, String nombre, String direccion) {
		
	}
	
	public List<Persona> getClientes(){
		return daoPersona.getAll();
	}
}
