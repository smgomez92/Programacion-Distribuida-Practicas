package com.distribuida.entidad;

import java.io.Serializable;
import java.sql.Date;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String identificacion;
	private Date fechaNacimiento;
	private String direccion;
	private String nombre; 

	public Persona () {
		
		
	}
	
	
	
	
	public Persona(int id, String identificacion, Date fechaNacimiento, String direccion, String nombre) {
		
		this.id = id;
		this.identificacion = identificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.nombre = nombre;
	}




	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+","+nombre+","+direccion+","+fechaNacimiento.toString()+","+identificacion;
	}

}
