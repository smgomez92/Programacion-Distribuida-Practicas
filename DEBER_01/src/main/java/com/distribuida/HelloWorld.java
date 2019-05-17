package com.distribuida;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloWorld {
	private String entrada;
	private String salida;

	public void submit() {
		salida = "Hola mundo has escrito " + entrada;

	}

	public String getEntrada() {
		return entrada;

	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSalida() {
		return salida;

	}
	
	public void setSalida(String salida) {
		this.entrada = salida;
	}

}
