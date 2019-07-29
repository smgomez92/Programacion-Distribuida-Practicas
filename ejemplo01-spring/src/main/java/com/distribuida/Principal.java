package com.distribuida;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.distribuida.config.ConfiguracionContenedor;
import com.distribuida.servicios.HolaMundo;

public class Principal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfiguracionContenedor.class);
		HolaMundo servicio =(HolaMundo)context.getBean("hola");
		HolaMundo servicio2 =context.getBean("holaMundoImpl",HolaMundo.class);
		System.out.println(servicio.hola("Test"));
		System.out.println(servicio2.hola("Test2"));
		System.out.println(servicio2.suma(1, 2));
		
		//impresion de beans
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


	}

}
