package com.distribuida.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.distribuida.Mantenimiento;


@Configuration
public class ConfigCliente {
	
	@Bean
	public HttpInvokerProxyFactoryBean servicio() {
		HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
		//Aquí configuré el puerto 8843 porque mi máquina ya tiene ocupado el 8080
		proxy.setServiceUrl("http://localhost:8843/PracticaHttp/app/http");
		proxy.setServiceInterface(Mantenimiento.class);
		return proxy;
	}
	

}
