package com.recuperacion.configuracion;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.recuperacion.controller.ControllerPersona;

@ApplicationPath("/app01")
public class ConfigApp01 extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		resources.add(ControllerPersona.class);
		return resources;
	}
	
	

}
