package com.practica.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.practica.config.Config;
import com.practica.servicios.Saludo;

public class Cliente {
	public static void main(String[] args) {
		//es el cliente que se va a conectar al server, en este caso estamos dentro de la aplicacion, pudiendo ser
		//otra app de Spring
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Saludo servicio = (Saludo)context.getBean("servicio");
		
		System.out.printf(servicio.hola("SANTIAGO"));

	}
}
