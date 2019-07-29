package com.thoughtmechanix.licenses.controllers;

import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
	// @Autowired
	// private LicenseService licenseService;
	//@Value("${example.property}")
	//private String id;
	@Value("${spring.datasource.password}")
	private String otro_dato;
	
	@RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
	public License getLicenses(@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		License l = new License();
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