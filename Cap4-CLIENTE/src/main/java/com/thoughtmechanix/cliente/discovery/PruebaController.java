package com.thoughtmechanix.cliente.discovery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.thoughtmechanix.cliente.model.License;
import com.thoughtmechanix.cliente.model.Organization;

@RestController
public class PruebaController {
	@Autowired
	DiscoveryClient discoveryClient;
	@Autowired
	OrganizationDiscoveryClient od;
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/testeo", method = RequestMethod.GET)
	public License prueba() {
		List<ServiceInstance> instances = discoveryClient.getInstances("licensingservice");
		for (ServiceInstance s : instances) {

			System.out.println("Puerto: " + s.getPort());
			System.out.println("URL: " + s.getUri());
			System.out.println("HOST: " + s.getHost());
			System.out.println("ID: " + s.getInstanceId());
		}
		String organizationId = "ELDONALDRT";
		if (instances.size() == 0)
			return null;
		String serviceUri = String.format("%s/v1/organizations/%s/licenses/todo/1", instances.get(0).getUri().toString(),
				organizationId);
		System.out.println("serviceUri: " +serviceUri);
		ResponseEntity<License> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, License.class,
				organizationId);

		// return "es una prueba: ** " + PruebaController.class.toString() + " **";
		return restExchange.getBody();
	}
}
