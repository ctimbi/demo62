package ec.edu.ups.demo62.servicios;

import ec.edu.ups.demo62.modelo.Persona;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("clientes")
public class GClientesService {

	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola mundo";
	}
	
	@GET
	@Path("suma")
	public String suma(@QueryParam("a") int a,
			@QueryParam("b") int b) {
		
		return " R = " + (a + b);
	}
	
	@GET
	@Path("multiplicacion/{a}/{b}")
	public String multiplicacion(@PathParam("a") int a,
			@PathParam("b") int b) {
		
		return " R = " + (a * b);
	}
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Persona misDatos() {
		Persona p = new Persona();
		p.setCedula("0103");
		p.setNombre("Cristian Timbi");
		
		return p;
	}
	
}
