package com.examen.distribuida.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.examen.distribuida.direcciones.Direccion;



@RestController
public class DireccionController {
	@GetMapping("/direccion/{type}") // @RequestMapping(value="/todo", method = {RequestMethod.GET})
	public ResponseEntity<Direccion> getDireccion(@PathVariable String type) {
		Direccion dir = new Direccion();
		dir.setDescripcion(type);
		return ResponseEntity.ok(dir);
	}
	
}
