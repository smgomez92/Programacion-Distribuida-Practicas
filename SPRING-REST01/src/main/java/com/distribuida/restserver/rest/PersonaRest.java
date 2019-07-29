package com.distribuida.restserver.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.distribuida.restserver.dto.Persona;
import com.distribuida.restserver.servicios.ServicioPersona;

 
// URL: http://localhost:8843/SPRING-REST01/api/personas/ 
@RestController//Hace q este componente sea un componente rest
@RequestMapping(path = "/personas")
public class PersonaRest {
	// private static final List<Persona> lista = new ArrayList<Persona>();
	@Autowired
	private ServicioPersona servicio;

	

	@GetMapping(path = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		System.out.println("**********************************");
		List<Persona> lista = servicio.listar();
		if (lista.isEmpty()) {
			return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscar(@PathVariable("id") int id) {
		System.out.println("**********************************" + id);
		Persona persona = servicio.buscar(id);
		if (persona == null) {
			return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<>(persona, HttpStatus.OK);
	}
	//, MediaType.APPLICATION_XML_VALUE}
	@PostMapping(path="/crear",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> crear(@RequestBody Persona per) {
		
		Persona persona =servicio.crear(per);
		
		return new ResponseEntity<>(persona, HttpStatus.CREATED);
	}
	
	@PutMapping(path ="/editar",produces="application/json",consumes="application/json")
	public ResponseEntity<Persona> editar(@RequestBody Persona p) {
	Persona pe= servicio.editar(p);
	return new ResponseEntity<>(pe, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		servicio.eliminar(id);
	}

}
