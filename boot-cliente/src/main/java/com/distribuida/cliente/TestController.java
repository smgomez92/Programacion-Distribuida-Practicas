package com.distribuida.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {
	@Autowired
	private DiscoveryClient registro;

	@GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public String test() {
		//buscar las instancias con el registro
		List<ServiceInstance>instancias = registro.getInstances("boot01");
		
		instancias.forEach(s->{
			System.out.printf("host: %s\n",s.getHost());
			System.out.printf("host: %d\n",s.getPort());
			System.out.println(s.getUri());
			
		});
		
		//Balanceador a dos servidores con el modulo del puerto
		for (ServiceInstance s : instancias) {
			int port=s.getPort();
			if(port%2==0) {
				System.out.println("Servidor A");
			} else {
				System.out.println("Servidor B");
			}
				
		}
		
		
		
		return "testeado";

	}
}
