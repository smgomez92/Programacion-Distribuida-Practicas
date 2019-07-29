package com.practica.ejbs;

import javax.ejb.Stateless;

@Stateless
public class HolaMundo implements HolaLocal{
	@Override
	public String hola(String nombre) {
		// TODO Auto-generated method stub
		return "Hola mi nombre es: "+nombre;
	}

}
