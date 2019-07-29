package com.thoughtmechanix.licenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Cap3ServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cap3ServerConfigApplication.class, args);
	}

}
