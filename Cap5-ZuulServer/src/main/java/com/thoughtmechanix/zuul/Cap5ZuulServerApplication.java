package com.thoughtmechanix.zuul;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class Cap5ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cap5ZuulServerApplication.class, args);
	}

	//Ejemplo del libro del Cloud Native Cap. 8 pag 222a
	@Bean
	CommandLineRunner commandLineRunner(RouteLocator routeLocator) {
		Log log = LogFactory.getLog(getClass());
		return args -> routeLocator.getRoutes()
				.forEach(r -> log.info(String.format("%s (%s) %s", r.getId(), r.getLocation(), r.getFullPath())));
	}

}
