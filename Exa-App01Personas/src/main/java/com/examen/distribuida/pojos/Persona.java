package com.examen.distribuida.pojos;

public class Persona {

	private int id;
	private String cedula;
	private Direccion direccion;
	private String nombre;
	private String tipoDireccion;
	
	public Persona () {}
	
	

	public Persona(int id, String cedula, Direccion direccion, String nombre, String tipoDireccion) {
		
		this.id = id;
		this.cedula = cedula;
		this.direccion = direccion;
		this.nombre = nombre;
		this.tipoDireccion=tipoDireccion;
	}



	public String getTipoDireccion() {
		return tipoDireccion;
	}



	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
