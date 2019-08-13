package com.prueba.distribuida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//Anotacion que habilita el servidor eureka en un servicio de Spring 
public class PruebaRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaRegistryServerApplication.class, args);
	}

}
