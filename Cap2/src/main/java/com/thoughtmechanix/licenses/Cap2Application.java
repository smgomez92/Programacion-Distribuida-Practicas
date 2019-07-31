package com.thoughtmechanix.licenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * 
 * 
 * @author santy
 * Clase que realiza el arranque de la aplicación 
 *
 */

@SpringBootApplication
@RefreshScope //Anotación para actualizar las propiedades si estas han sido alteradas en el server config
//@EnableDiscoveryClient //esto debe ir en el cliente 
public class Cap2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cap2Application.class, args);
	}
	
	
	//esto debe ir en el proyecto cliente
	@LoadBalanced
	  @Bean
	  public RestTemplate getRestTemplate(){
	      return new RestTemplate();
	  }

}
