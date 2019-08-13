package com.examen.distribuida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
//@EnableZuulProxy descomentar para cuando se use ZUUL 
public class ExaGatewayServerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ExaGatewayServerApplication.class, args);
	}
	
	//Para fijar las rutas manuales
//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//	    return builder.routes()
//	    		.route( p->p
//	    				.path("/app1")
//	    				.uri( "http://127.0.0.1/aa" )
//	    			)
//	    		.build();
//	}

	
}
