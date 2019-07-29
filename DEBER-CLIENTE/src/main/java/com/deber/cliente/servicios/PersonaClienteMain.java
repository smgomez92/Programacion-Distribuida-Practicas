package com.deber.cliente.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericType;

import com.deber.cliente.pojo.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonaClienteMain {
	public static final String URL = "http://localhost:8843/DEBER-SERVER/app";

	private static void testJson() throws Exception {

		System.out.println("------------------------------------------------");
		System.out.println("-- Test json");

		Client client = ClientBuilder.newClient();

		// ----------------------------------------------------
		// obtener el typo de dato como String: json
		String responseJson = client.target(URL).path("/personas/{id}").resolveTemplate("id", 100)
				.request(MediaType.APPLICATION_JSON).get(String.class);

		System.out.println("json string: " + responseJson);

		// deserializar el JSON
		ObjectMapper mapper = new ObjectMapper();
		Persona p = mapper.readValue(responseJson, Persona.class);

		System.out.println("id    : " + p.getId());
		System.out.println("nombre: " + p.getNombre());
	}

	private static void listarPersonas() throws Exception {
		List<Persona> personas = null;
		System.out.println("------------------------------------------------");
		System.out.println("-- listar");

		Client client = ClientBuilder.newClient();
		personas = client.target(URL).path("/personas/listar").request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Persona>>() {
				});

		for (Persona p : personas) {
			System.out.println("Id: " + p.getId());
			System.out.println("Nombre: " + p.getNombre());
		}
	}

	public static void otroListar() {
		Client client = ClientBuilder.newClient();
		String responseJson = client.target(URL).path("/personas/listar").request(MediaType.APPLICATION_JSON)
				.get(String.class);
		System.out.println("resultado " + responseJson);
	}

	public static void eliminar() {
		Client client = ClientBuilder.newClient();

		Response r = client.target(URL).path("/personas/delete/{id}").resolveTemplate("id", 4).request().delete();

		System.out.println("resultado " + r.getStatus() + " " + r.getLength());

	}
	public static void actualizar() {
		Client client = ClientBuilder.newClient();
		
		Response r = client.target(URL).path("/personas/actualizar/{id}").resolveTemplate("id", 1).request()
                .put(Entity.entity(new Persona(12,"PUT"), MediaType.APPLICATION_XML));

		System.out.println("resultado " + r.getStatus() + " " + r.getLength());

	}

	public static void crear() {
		Persona p = new Persona(12,"post");
		
		Client client = ClientBuilder.newClient();
		Response r = client.target(URL).path("/personas/crear").request()
				.post(Entity.entity(p, MediaType.APPLICATION_XML));
		System.out.println("resultado " + r.getStatus() + " " + r.getLength());
		
	}
	
	
	

	public static void main(String[] args) throws Exception {
	//crear();
		//eliminar();
		//listarPersonas();
		// otroListar();
		 //testJson();
	actualizar();
		

	}

}
