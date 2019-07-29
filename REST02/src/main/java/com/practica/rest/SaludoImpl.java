package com.practica.rest;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoImpl implements Saludo {
	@GetMapping(path="/hola",produces=MediaType.APPLICATION_JSON_VALUE)
	public String hola() {
		return "servicio rest";		
	}

}
