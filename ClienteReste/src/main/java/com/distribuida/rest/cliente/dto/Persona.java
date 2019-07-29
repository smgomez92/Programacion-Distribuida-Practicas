package com.distribuida.rest.cliente.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
//para registrar la clase 
@XmlRootElement(name = "persona")
public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private int id;
	 private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 
}

