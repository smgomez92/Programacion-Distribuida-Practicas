package com.distribuida.rest.cliente.servicios;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class RestClient02Main {
	public static final String URL = "http://localhost:8843/Ejemplo-rest03/app";
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		String response =  client.target( URL )
			.path("/holamundo/{nombre}")
			.resolveTemplate("nombre", "mundo")
			.request( MediaType.APPLICATION_XML )
			.get( String.class );
		
		System.out.println( "RESPUETA: " + response );
	}

}
