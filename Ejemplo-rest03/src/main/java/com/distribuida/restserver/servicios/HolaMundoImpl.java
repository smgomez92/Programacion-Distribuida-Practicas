package com.distribuida.restserver.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//ip:puerto/contexto/app/nombre_path/parametro
@Path("/")
public class HolaMundoImpl {

	@GET
	@Path(value = "/mundo/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public String holaMundo(@PathParam("nombre") String nombre) {

		return "Hola " + nombre;
	}

	
}
