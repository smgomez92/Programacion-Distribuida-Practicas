package com.distribuida.clienterest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.distribuida.persona.Persona;

public class RestClient {
	public static void main(String args[]) {

		// buscar(1);
		//crear();
		listar();
		//editar(5);
		// eliminar(5);

	}

	public static void buscar(int id) {
		RestTemplate restTemplate = new RestTemplate();
		Persona p = restTemplate.getForObject("http://localhost:8843/SPRING-REST01/api/personas/{id}", Persona.class,
				id);
		System.out.println(p.toString());

	}

	public static void crear() {
		RestTemplate restTemplate = new RestTemplate();
		Persona persona = new Persona();
		persona.setId(5);
		persona.setNombre("Quinto");
		restTemplate.postForObject("http://localhost:8843/SPRING-REST01/api/personas/crear", persona, Persona.class);

	}

	public static void listar() {
		RestTemplate restTemplate = new RestTemplate();
		List<Persona> personas = new ArrayList<Persona>();
		ResponseEntity<List<Persona>> response = restTemplate.exchange(
				"http://localhost:8843/SPRING-REST01/api/personas/listar", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Persona>>() {
				});
		personas = response.getBody();
		for (Persona p : personas) {
			System.out.println(p.toString());

		}

	}

	public static void editar(int id) {
		RestTemplate restTemplate = new RestTemplate();
		Persona p = restTemplate.getForObject("http://localhost:8843/SPRING-REST01/api/personas/{id}", Persona.class,
				id);
		p.setNombre("Nuevo Nombre de Quinto");
		HttpEntity<Persona> pEditada = new HttpEntity<>(p);
		restTemplate.exchange("http://localhost:8843/SPRING-REST01/api/personas/editar", HttpMethod.PUT, pEditada,
				Persona.class);

	}

	public static void eliminar(int id) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8843/SPRING-REST01/api/personas/eliminar/" + id);

	}

}
