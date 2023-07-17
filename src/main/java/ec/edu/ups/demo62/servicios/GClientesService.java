package ec.edu.ups.demo62.servicios;

import java.util.List;

import ec.edu.ups.demo62.modelo.Persona;
import ec.edu.ups.demo62.negocio.GestionClientes;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class GClientesService {
	
	@Inject
	private GestionClientes gClientes;

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
	
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Persona persona) {
		try {
			gClientes.guardarClientes(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("all")
	@Produces("application/json")
	public Response getClientes() {
		List<Persona> listado = gClientes.getClientes();
		
		return Response.status(Response.Status.OK).entity(listado).build();
	}
	
}
