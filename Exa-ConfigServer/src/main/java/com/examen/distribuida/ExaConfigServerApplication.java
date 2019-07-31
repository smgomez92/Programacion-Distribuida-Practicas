package com.examen.distribuida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ExaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaConfigServerApplication.class, args);
	}

}
