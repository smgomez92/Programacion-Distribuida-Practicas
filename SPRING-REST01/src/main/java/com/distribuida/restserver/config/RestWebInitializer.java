package com.distribuida.restserver.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RestWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses(){
		
		return new Class<?>[] {
			ServiceConfig.class
		};
	}
	@Override
	protected Class<?>[] getServletConfigClasses(){
		

		return new Class<?>[] {
			WebConfig.class
		};
	}
	
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String [] {"/api/*"};
	}

}
