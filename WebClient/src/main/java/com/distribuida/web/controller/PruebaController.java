package com.distribuida.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.distribuida.web.dto.Direccion;
import com.distribuida.web.dto.Persona;

@Controller
public class PruebaController {
	@Autowired
	RestTemplate restTemplate;

	private List<Persona> personas = new ArrayList<Persona>();
	@Value("${url.gateway}")
	String GATEWAY;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(ModelMap model) {

		ResponseEntity<List<Persona>> response = restTemplate.exchange(GATEWAY + "APP01/personas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Persona>>() {
				});
		personas = response.getBody();
		model.addAttribute("lista", personas);
		return "personas";
	}

	@RequestMapping(value = "/editar/{id}")
	public String editar(@PathVariable("id") String id, ModelMap model) {
		List<Direccion> direcciones = new ArrayList<Direccion>();
		ResponseEntity<Persona> p = restTemplate.exchange(GATEWAY + "APP01/persona/" + id, HttpMethod.GET, null,
				Persona.class);

		ResponseEntity<List<Direccion>> response = restTemplate.exchange(GATEWAY + "APP02/direcciones", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Direccion>>() {
				});
		direcciones = response.getBody();
		model.addAttribute("persona", p.getBody());
		model.addAttribute("direcciones", direcciones);
		return "editar-persona";

	}

	@RequestMapping(value = "/crear")
	public String crear(Persona persona, ModelMap model) {
		List<Direccion> direcciones = new ArrayList<Direccion>();
		ResponseEntity<List<Direccion>> response = restTemplate.exchange(GATEWAY + "APP02/direcciones", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Direccion>>() {
				});
		direcciones = response.getBody();
		model.addAttribute("direcciones", direcciones);

		return "crear-persona";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/editar-persona", method = RequestMethod.POST)
	public String editar(Persona persona, ModelMap model) {

		HttpEntity<Persona> pEditada = new HttpEntity<>(persona);
		restTemplate.exchange(GATEWAY + "APP01/persona/editar", HttpMethod.PUT, pEditada, Persona.class);
		System.out.println(persona.toString());

		ResponseEntity<List<Persona>> response = restTemplate.exchange(GATEWAY + "APP01/personas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Persona>>() {
				});
		personas = response.getBody();
		model.addAttribute("lista", personas);
		return "personas";
	}

	@RequestMapping(value = "/crear-persona", method = RequestMethod.POST)
	public String crear_persona(Persona persona, ModelMap model) {
		System.out.println(persona.toString());
		HttpEntity<Persona> pCreada = new HttpEntity<>(persona);
		restTemplate.exchange(GATEWAY + "APP01/persona/crear", HttpMethod.PUT, pCreada, Persona.class);

		ResponseEntity<List<Persona>> response = restTemplate.exchange(GATEWAY + "APP01/personas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Persona>>() {
				});
		personas = response.getBody();
		model.addAttribute("lista", personas);
		return "personas";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable("id") String id, ModelMap model) {
		//mandar un delete al micro para eliminiar la persona
		restTemplate.delete(GATEWAY + "APP01/persona/delete/" + id);

		ResponseEntity<List<Persona>> response = restTemplate.exchange(GATEWAY + "APP01/personas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Persona>>() {
				});
		personas = response.getBody();
		model.addAttribute("lista", personas);
		return "personas";

	}

}
