package com.distribuida.rest.cliente.servicios;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class RestClient01Main {
	public static final String URL = "http://localhost:8843/Ejemplo-rest03/app";
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target( URL );
		
		target = target.path("/{id}" );
		
		target = target.resolveTemplate( "id", "1" );
		
		Invocation.Builder builder = target.request();
		
		String respuesta = builder.get( String.class );
		
		System.out.println( "RESPUESTA: " + respuesta );
	}

}
