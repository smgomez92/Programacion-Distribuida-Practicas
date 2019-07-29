package com.practica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.practica.servicios.Saludo;



@Configuration
@ComponentScan(basePackages="com.practica.servicios")
public class Config {
	@Bean
	public HttpInvokerProxyFactoryBean servicio() {
		HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
		proxy.setServiceUrl("http://localhost:8080/PracticaHttp/app/http");
		proxy.setServiceInterface(Saludo.class);
		return proxy;
	}
}
