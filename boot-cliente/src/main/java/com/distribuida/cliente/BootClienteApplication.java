package com.distribuida.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootClienteApplication.class, args);
	}

}
