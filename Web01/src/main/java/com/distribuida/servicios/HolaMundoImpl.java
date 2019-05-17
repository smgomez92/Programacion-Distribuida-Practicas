package com.distribuida.servicios;

import org.springframework.stereotype.Component;

@Component
public class HolaMundoImpl implements HolaMundo {
	@Override
	public String hola(String nombre) {
		Persona p = new Persona();
		return String.format("Hola %s", nombre +" "+p.getNombre());

	}
}
