package com.distribuida.restserver.app;



import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.distribuida.restserver.servicios.HolaMundoImpl;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

// ver jaxrs.application.address.ignore en web.xml

@ApplicationPath("/app")//aumenta al mapeo del servlet http:localhost:8080/api/app/Ejemplo-rest01/holamundo/ si el valor de inicio es false
public class RestServerApplication extends Application 
{

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> classes = new HashSet<Class<?>>();
		
		classes.add( HolaMundoImpl.class );
		
		//providers 
		classes.add( JacksonJsonProvider.class );
		//si queremos ingressar otro servicio lo añadimos
		return classes;
	}

}
