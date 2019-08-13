package com.recuperacion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.resource.spi.ConfigProperty;
import javax.transaction.Transactional;
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

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
//import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import com.recuperacion.modelo.Persona;
import com.recuperacion.servicios.ServicioPersona;


@Path("/personas")
public class ControllerPersona {
	
	@Inject
	@ConfigProperty
	private ServicioPersona service;
	private List<Persona> lista;

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		try {
			lista = new ArrayList<>();
			lista = service.listar();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.status(Response.Status.OK).entity(lista).build();

	}

	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Persona persona) {
		try {
			service.crearPersona(persona);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(persona).build();

	}

	@PUT
	@Path("/editar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Persona persona) {
		try {
			service.editarPersona(persona);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(persona).build();

	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminar/{id}")
	@Transactional
	public Response eliminar(@PathParam("id") Integer id) {
		try {
			Persona per = service.buscarPorId(id);
			service.eliminarPersona(per);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.noContent().build();
	}

	@Retry
	@CircuitBreaker
	@Fallback(fallbackMethod = "obtenerPersona")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public Response listarPorId(@PathParam("id") Integer id) {
		Persona per = new Persona();
		try {

			per = service.buscarPorId(id);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(per).build();
	}

	public Persona obtenerPersona(Integer id) {
		return service.buscarPorId(id);
	}

}
