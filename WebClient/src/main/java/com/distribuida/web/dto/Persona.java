package com.distribuida.web.dto;

public class Persona {
	private int id;
	private String nombre;
	private String cedula;
	private String direccion;
	private String tipoDireccion;

	public Persona() {
	}

	public Persona(int id, String nombre, String cedula, String direccion, String tipoDireccion) {

		this.id = id;
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
		this.tipoDireccion = tipoDireccion;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", direccion=" + direccion
				+ ", tipoDireccion=" + tipoDireccion + "]";
	}
	
	
	

}