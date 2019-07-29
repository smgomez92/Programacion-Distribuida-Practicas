package com.distribuida.servicios;

import org.springframework.stereotype.Component;

@Component
public class HolaMundoImpl implements HolaMundo {
	@Override
	public String hola(String nombre) {
		return String.format("Hola %s", nombre);

	}

	@Override
	public int suma(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}
}
