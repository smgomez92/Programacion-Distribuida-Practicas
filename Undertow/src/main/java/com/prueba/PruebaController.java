package com.prueba;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/prueba")
public class PruebaController {
	@GetMapping(value="/under")
	public String prueba() {
		
		return "desde undertow";
	}

}
