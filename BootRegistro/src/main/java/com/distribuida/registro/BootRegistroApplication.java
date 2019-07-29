package com.distribuida.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootRegistroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRegistroApplication.class, args);
	}

}
