package com.thoughtmechanix.licenses.controllers;


import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Clase que tiene la anotación @RestController la cual le dice a Spring que esta será una clase 
 * controladora. 
 * 
 */

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")//cambiar el path por uno acorde
public class LicenseServiceController {
	@Autowired
	private LicenseService licenseService;//inyeccion de dependencia que implementa los servicios
	/*
	 * inyeccion de valores mediante la anotación @Value la cual recupera los valores del
	 * archivo de propiedades en el server config 
	 */
	//@Value("${example.property}")
	//private String id; // 
	@Value("${spring.datasource.password}")
	private String otro_dato;
	
	
	//método GET recupera un objeto del tipo license
	@RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
	public License getLicenses(@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		License l = new License();//modelo de la estructura de dato a devolver
		l.setLicenseId(otro_dato);
		l.setLicenseType("Licencia tipo B q nunca voy a tener :v");
		l.setOrganizationId("ALV");
		l.setProductName(licenseId);
		// return licenseService.getLicense(licenseId);
		// return new
		// License().withId(licenseId).withOrganizationId(organizationId).withProductName("Valiendo")
		// .withLicenseType("Madres");
		return l;
	}
	
	// Buscar por Id
		@GetMapping("/todo/{id}")
		public ResponseEntity<License> getToDoById(@PathVariable String id) {
			License l = new License();//modelo de la estructura de dato a devolver
			l.setLicenseId(otro_dato);
			l.setLicenseType("Licencia tipo B q nunca voy a tener :v");
			l.setOrganizationId("ALV");
			l.setProductName("licenseId");
			return ResponseEntity.ok(l);
		}

	
	@RequestMapping(value="/{licenseId}/{clientType}",method = RequestMethod.GET)
    public License getLicensesWithClient( @PathVariable("organizationId") String organizationId,
                                          @PathVariable("licenseId") String licenseId,
                                          @PathVariable("clientType") String clientType) {

        return licenseService.getLicense(organizationId,licenseId, clientType);
    }
	
	@RequestMapping(value = "{licenseId}", method = RequestMethod.PUT)
	public String updateLicenses(@PathVariable("licenseId") String licenseId) {
		return String.format("This is the put");
	}

	@RequestMapping(value = "{licenseId}", method = RequestMethod.POST)
	public String saveLicenses(@PathVariable("licenseId") String licenseId) {
		return String.format("This is the post");
	}

	@RequestMapping(value = "{licenseId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteLicenses(@PathVariable("licenseId") String licenseId) {
		return String.format("This is the Delete");
	}
}