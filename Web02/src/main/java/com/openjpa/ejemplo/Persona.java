package com.openjpa.ejemplo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TPERSONA")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column(name="cpersona")
	@Id	
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion")
	private String direccion;
	
	public Persona() {
		
		
	}

	public Persona(Long id, String nombre, String direccion) {
		
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	
	 

}
