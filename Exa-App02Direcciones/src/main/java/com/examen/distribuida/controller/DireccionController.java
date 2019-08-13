package com.examen.distribuida.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examen.distribuida.direcciones.Direccion;

import com.examen.distribuida.service.DireccionServicio;

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
		
		// Crear
		@RequestMapping(value = "/direccion/crear", method = { RequestMethod.POST, RequestMethod.PUT })
		public ResponseEntity<?> createDireccion(@Valid @RequestBody Direccion p) {
			
			Direccion e = ds.saveDireccion(p);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/direccion").buildAndExpand(e.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
		
		//editar
		@PatchMapping("/direccion/editar")
		public ResponseEntity<Direccion> setDireccion(@RequestBody Direccion p) {
			ds.updateDireccion(p);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(p.getId()).toUri();

			return ResponseEntity.ok().header("Location", location.toString()).build();
		}
		
		@DeleteMapping("/direccion/delete")
		public ResponseEntity<Direccion> deletePersona(@RequestBody Direccion p) {
			Direccion p1 = ds.findByid(String.valueOf(p.getId()));
			ds.deleteDireccion(p1);
			return ResponseEntity.noContent().build();
		}

}
