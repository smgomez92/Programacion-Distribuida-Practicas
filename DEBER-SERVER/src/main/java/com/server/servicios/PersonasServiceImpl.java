package com.server.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.server.pojo.Persona;

//http://ip:puerto/contexto/personas/id
@Path("/personas")
public class PersonasServiceImpl {
	private static final List<Persona> lista = new ArrayList<Persona>();

	static {
		lista.add(new Persona(1, "Santiago"));
		lista.add(new Persona(2, "Mauricio Gómez"));
		lista.add(new Persona(3, "Michu"));
		lista.add(new Persona(4, "Cuarto"));
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Persona buscar(@PathParam(value = "id") int id) {

		Persona p = new Persona();
		p.setId(id);
		p.setNombre(String.format("persona-%d", id));
		return p;
	}
	// lo anterior devolverá formato XML o json

	@GET
	@Path("/listar")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Persona> listar() {

		return lista;
	}

	@DELETE
	@Path("/delete/{id}")
	public Response eliminar(@PathParam(value = "id") int id) {

		if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == id) {
					lista.remove(i);
					return Response.ok().build();

				}

			}

		}

		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@POST
	@Path("/crear")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response crear(Persona p) {
		lista.add(p);
		return Response.ok(p).build();
	}
	
	@PUT
	@Path("/actualizar/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response actualizar(@PathParam(value="id")int id,Persona p) {
		if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == id) {
					lista.get(i).setId(p.getId());
					lista.get(i).setNombre(p.getNombre());
					return Response.ok(lista.get(i)).build();

				}

			}

		}
		return Response.ok(p).build();
	}
		

}
