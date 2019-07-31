package com.thoughtmechanix.licenses.config;

/*
 * 
 * 
 * clase que recupera un valor del archivo de propiedades del server config 
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {
	
	@Value("${example.property}")
	  private String exampleProperty;

	  public String getExampleProperty(){
	    return exampleProperty;
	  }

}
