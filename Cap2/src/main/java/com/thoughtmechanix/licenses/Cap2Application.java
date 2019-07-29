package com.thoughtmechanix.licenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope //Anotación para actualizar las propiedades si estas han sido alteradas en el server config
public class Cap2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cap2Application.class, args);
	}

}
