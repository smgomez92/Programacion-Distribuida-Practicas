package com.distribuida.rest.cliente.servicios;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.distribuida.rest.cliente.dto.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class PersonasRestClientMain {

	// public static final String URL = "http://localhost:8843/Ejemplo-rest03/app";
	public static final String URL = "http://localhost:8843/SPRING-REST01/api";

	private static void testJson() throws Exception {

		System.out.println("------------------------------------------------");
		System.out.println("-- Test json ----");

		Client client = ClientBuilder.newClient();

		// ----------------------------------------------------
		// obtener el typo de dato como String: json
		String responseJson = client.target(URL).path("/personas/{id}").resolveTemplate("id", 1)
				.request(MediaType.APPLICATION_JSON).get(String.class);

		System.out.println("json string: " + responseJson);

		// deserializar el JSON
		ObjectMapper mapper = new ObjectMapper();
		Persona p = mapper.readValue(responseJson, Persona.class);

		System.out.println("id    : " + p.getId());
		System.out.println("nombre: " + p.getNombre());
	}

	private static void testXml() throws Exception {

		System.out.println("------------------------------------------------");
		System.out.println("-- Test xml");

		Client client = ClientBuilder.newClient();

		// obtener el typo de dato como String: xml
		String responseXml = client.target(URL).path("/personas/{id}").resolveTemplate("id", 1)
				.request(MediaType.APPLICATION_XML).get(String.class);

		System.out.println("xml string: " + responseXml);

		// deserializar el XML
		JAXBContext jaxbContext = JAXBContext.newInstance(Persona.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Persona p = (Persona) jaxbUnmarshaller.unmarshal(new StringReader(responseXml));

		System.out.println("id    : " + p.getId());
		System.out.println("nombre: " + p.getNombre());
	}

	private static void testJson2Persona() throws Exception {

		System.out.println("------------------------------------------------");
		System.out.println("-- Test json==>persona");

		Client client = ClientBuilder.newClient().register(new JacksonJsonProvider());

		// ----------------------------------------------------
		// obtener el typo de dato como String: xml
		Persona p = client.target(URL).path("/personas/{id}").resolveTemplate("id", 22)
				.request(MediaType.APPLICATION_JSON).get(Persona.class);

		System.out.println("id    : " + p.getId());
		System.out.println("nombre: " + p.getNombre());
	}

	private static void testXml2Persona() throws Exception {

		System.out.println("------------------------------------------------");
		System.out.println("-- Test xml==>persona");

		Client client = ClientBuilder.newClient();

		// ----------------------------------------------------
		// obtener el typo de dato como String: xml
		Persona p = client.target(URL).path("/personas/{id}").resolveTemplate("id", 1)
				.request(MediaType.APPLICATION_XML).get(Persona.class);

		System.out.println("id    : " + p.getId());
		System.out.println("nombre: " + p.getNombre());

	}

	@SuppressWarnings("unchecked")
	private static void listarPersonas() throws Exception {
		List<Persona> personas = new ArrayList<Persona>();
		System.out.println("------------------------------------------------");
		System.out.println("-- listar");

		Client client = ClientBuilder.newClient();

		// ----------------------------------------------------
		// obtener el typo de dato como String: xml
		Response r = client.target(URL).path("/personas/listar").request(MediaType.APPLICATION_JSON).get();
		System.out.println(r.getEntity());
		personas = (List<Persona>) r.getEntity();

	}
	
	private static void listar() throws Exception {
		Persona personas[] =null;
		System.out.println("------------------------------------------------");
		System.out.println("-- listar");

		Client client = ClientBuilder.newClient();
		String per = client.target(URL).path("/personas/listar").request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		personas = mapper.readValue(per, Persona[].class);
		System.out.println("Personas: ");
		for(int i=0 ; i<personas.length; i++) {
			System.out.println("Id:" + personas[i].getId()+"\nNombre: "+personas[i].getNombre());
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// listarPersonas();

		try {
			 //testJson();
			// testXml( );
			//testJson2Persona();
			// testXml2Persona( );
			listar();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: " + e.toString());
		}

	}

}
