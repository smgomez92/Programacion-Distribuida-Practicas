package com.distribuida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.distribuida.modelo.Usuario;
import com.distribuida.servicio.ServicioUsuario;

@RestController
public class UsuarioController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private ServicioUsuario servicioUsuario;



	// Listar
	@GetMapping("/usuarios")
	public ResponseEntity<Iterable<Usuario>> getUsuario() {
		return ResponseEntity.ok(servicioUsuario.findAll());
	}

	// Buscar por id
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getPersona(@PathVariable String id) {
		return ResponseEntity.ok(servicioUsuario.findByid(id));
	}

}
