package com.distribuida.entidad;

import javax.ejb.Stateless;
@Stateless
public class Persona {
private int id;
private String nombre;
private String direccion;

public Persona() {
	
	
}

public Persona(int id, String nombre, String direccion) {
	this.id = id;
	this.nombre = nombre;
	this.direccion = direccion;
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

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

@Override
public String toString() {
	return "Persona [id=" + id + ", nombre=" + nombre + ", direcci�n=" + direccion + "]";
}



}
