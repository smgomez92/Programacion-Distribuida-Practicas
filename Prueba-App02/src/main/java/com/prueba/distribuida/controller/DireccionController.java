package com.prueba.distribuida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.distribuida.pojos.Direccion;
import com.prueba.distribuida.servicios.DireccionServicio;



@RestController
public class DireccionController {
	@Autowired
	DireccionServicio ds;

	@GetMapping("/direccion/{type}") 
	public ResponseEntity<Direccion> getDireccion(@PathVariable String type) {
		Direccion dir = new Direccion();
		dir = ds.findByid(type);
		return ResponseEntity.ok(dir);
	}
	
		// Listar
		@GetMapping("/direcciones")
		public ResponseEntity<Iterable<Direccion>> getPersonas() {
			return ResponseEntity.ok(ds.findAll());
		}

}
