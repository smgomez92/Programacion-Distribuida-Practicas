package com.examen.distribuida.pojos;

public class Persona {

	private int id;
	private String cedula;
	private String direccion;
	private String nombre;
	private String tipoDireccion;
	private int idDir;

	public Persona() {
	}

	public Persona(int id, String cedula, String direccion, String nombre, String tipoDireccion) {

		this.id = id;
		this.cedula = cedula;
		this.direccion = direccion;
		this.nombre = nombre;
		this.tipoDireccion = tipoDireccion;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdDir() {
		return idDir;
	}

	public void setIdDir(int idDir) {
		this.idDir = idDir;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", cedula=" + cedula + ", direccion=" + direccion + ", nombre=" + nombre
				+ ", tipoDireccion=" + tipoDireccion + ", idDir=" + idDir + "]";
	}

}
