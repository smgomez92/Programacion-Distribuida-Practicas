package com.thoughtmechanix.licenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//Anotacion que habilita el servidor eureka en un servicio de Spring 

public class Cap4ServerRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cap4ServerRegistryApplication.class, args);
	}

}
