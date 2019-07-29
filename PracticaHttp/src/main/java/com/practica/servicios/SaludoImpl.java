package com.practica.servicios;

import org.springframework.stereotype.Component;

@Component
public class SaludoImpl implements Saludo {
	@Override
	public String hola(String nombre) {
		// 
		return "Hola "+nombre;
	}

}
