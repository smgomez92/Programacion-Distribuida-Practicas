package com.prueba.distribuida.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prueba.distribuida.pojos.Direccion;
import com.prueba.distribuida.pojos.Persona;
import com.prueba.distribuida.servicios.ServicioPersona;

@RestController
public class PersonaController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private ServicioPersona servicePersona;

	// Listar
	@GetMapping("/personas")
	public ResponseEntity<Iterable<Persona>> getPersonas() {
		return ResponseEntity.ok(servicePersona.findAll());
	}

	// Buscar por id
	@GetMapping("/persona/{id}")
	public ResponseEntity<Persona> getPersona(@PathVariable String id) {
		return ResponseEntity.ok(servicePersona.findByid(id));
	}

	// Crear
	@RequestMapping(value = "/persona/crear/{id}", method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<?> createPersona(@Valid @RequestBody Persona p, @PathVariable String id) {
		Direccion dir = this.getDirecciones(p.getTipoDireccion());
		p.setDireccion(String.valueOf(dir.getId()));
		Persona e = servicePersona.savePerson(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/persona").buildAndExpand(e.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PatchMapping("/persona/editar")
	public ResponseEntity<Persona> setPersona(@RequestBody Persona p) {
		servicePersona.updatePersona(p);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(p.getId()).toUri();

		return ResponseEntity.ok().header("Location", location.toString()).build();
	}

	@DeleteMapping("/persona/delete")
	public ResponseEntity<Persona> deletePersona(@RequestBody Persona p) {
		Persona p1 = servicePersona.findByid(String.valueOf(p.getId()));
		servicePersona.deletePersona(p1);
		return ResponseEntity.noContent().build();
	}

	/**
	 * 
	 * 
	 * obtener los datos de la direccion del la aplicacion de direcciones;
	 * Balanceando la carga manualmente
	 * 
	 */
	public Direccion getDirecciones(String id) {
		Direccion dire = null;
		// para obtener las instancias de la app de direcciones
		List<ServiceInstance> instances = discoveryClient.getInstances("app02-direcciones");
		for (ServiceInstance si : instances) {
			System.out.println("----------------------");
			System.out.println("URL:" + si.getUri().toString());
			System.out.println("----------------------");

		}

		if (instances.size() == 0) {
			return null;
		}

		for (ServiceInstance si : instances) {
			if (si.getPort() % 2 == 0) {

				String serviceUri = String.format("%s/direccion/" + id, si.getUri().toString());
				ResponseEntity<Direccion> direccion = restTemplate.exchange(serviceUri, HttpMethod.GET, null,
						Direccion.class);
				dire = direccion.getBody();
				break;
			} else {
				String serviceUri = String.format("%s/direccion/" + id, si.getUri().toString());
				ResponseEntity<Direccion> direccion = restTemplate.exchange(serviceUri, HttpMethod.GET, null,
						Direccion.class);
				dire = direccion.getBody();
				break;
			}
		}
		return dire;

	}

	// @GetMapping("/prueba/{id}")
	// public ResponseEntity<Direccion> test(@PathVariable String id) {
	// Direccion dir = this.getDirecciones(id);
	// return ResponseEntity.ok(dir);
	// }

}
