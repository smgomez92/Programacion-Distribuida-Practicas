package com.distribuida.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.distribuida.servicios.HolaMundo;
import com.distribuida.servicios.HolaMundoImpl;

@Configuration
@ComponentScan(basePackages = "com.distribuida.servicios")
public class ConfiguracionContenedor {
@Bean(name="hola")
public HolaMundo hola() {
	return new  HolaMundoImpl();
}
@Bean(name="hola1")
public HolaMundo holaMundo() {
	return new  HolaMundoImpl();
}
}
