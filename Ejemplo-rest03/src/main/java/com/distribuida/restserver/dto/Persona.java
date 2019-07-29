package com.distribuida.restserver.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

//para registrar la clase 
@XmlRootElement(name = "persona")
public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;

	public Persona() {
	}

	public Persona(int id, String nombre) {

		this.id = id;
		this.nombre = nombre;
	}

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
