package com.examen.distribuida.controller;

import java.net.URI;
//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examen.distribuida.pojos.Direccion;
import com.examen.distribuida.pojos.Persona;
import com.examen.distribuida.servicios.ServicioPersona;

@RestController
public class PersonaController {
	// @Autowired
	// private DiscoveryClient discoveryClient;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private ServicioPersona servicePersona;
	@Value("${gateway.url}")
	private String GATEWAY;

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
	@RequestMapping(value = "/persona/crear", method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<?> createPersona(@Valid @RequestBody Persona p) {
		Direccion dir = this.getDirecciones(p.getTipoDireccion());
		p.setIdDir(dir.getId());
		p.setTipoDireccion(dir.getDescripcion());
		Persona e = servicePersona.savePerson(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/persona").buildAndExpand(e.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	//editar
	@PutMapping("/persona/editar")
	public ResponseEntity<Persona> setPersona(@RequestBody Persona p) {
		servicePersona.updatePersona(p);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(p.getId()).toUri();

		return ResponseEntity.ok().header("Location", location.toString()).build();
	}

	@DeleteMapping("/persona/delete/{id}")
	public ResponseEntity<Persona> deletePersona(@PathVariable String id) {
		//Persona p1 = servicePersona.findByid(String.valueOf(p.getId()));
		servicePersona.deletePersona(id);
		return ResponseEntity.noContent().build();
	}

//	// obtener los datos de la direccion del la aplicacion de direcciones;
//	public Direccion getDirecciones() {
//
//		// para obtener las instancias de la app de direcciones
//		List<ServiceInstance> instances = discoveryClient.getInstances("app02");
//
//		if (instances.size() == 0)
//			return null;
//		String serviceUri = String.format("%s/direccion/", instances.get(0).getUri().toString());
//
//		ResponseEntity<Direccion> direccion = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Direccion.class);
//
//		return direccion.getBody();
//	}

	// obtener los datos de la direccion del la aplicacion de direcciones;
	public Direccion getDirecciones(String id) {
		String serviceUri = GATEWAY + "/APP02/direccion/" + id;
		//System.out.println("*******************"+serviceUri);
		ResponseEntity<Direccion> direccion = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Direccion.class);

		return direccion.getBody();
	}

}
