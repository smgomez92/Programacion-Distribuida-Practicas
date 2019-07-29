package com.distribuida.restserver.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.restserver.dto.Persona;
//http://ip:puerto/contexto/personas/id
@Path("/personas")
public class PersonasServiceImpl {

	@GET
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public Persona buscar( @PathParam(value="id") int id ) {
		
		Persona p = new Persona();		
		p.setId( id );
		p.setNombre( String.format("persona-%d", id) );
		return p;
	}
	//lo anterior devolverá formato XML o json
	
	@GET
	@Path("/listar")
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public List<Persona> lisar() {
		List <Persona> lista = new ArrayList<Persona>();
		lista.add(new Persona(1,"Santiago"));
		lista.add(new Persona(2,"Mauricio Gómez"));
		lista.add(new Persona(3,"Michu"));

		return lista;
	}
}
