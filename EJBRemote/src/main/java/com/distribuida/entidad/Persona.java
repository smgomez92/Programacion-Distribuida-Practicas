package com.distribuida.entidad;

public class Persona {
private int id;
private String nombre;
private String direcci�n;

public Persona() {
	
	
}

public Persona(int id, String nombre, String direcci�n) {
	this.id = id;
	this.nombre = nombre;
	this.direcci�n = direcci�n;
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

public String getDirecci�n() {
	return direcci�n;
}

public void setDirecci�n(String direcci�n) {
	this.direcci�n = direcci�n;
}

@Override
public String toString() {
	return "Persona [id=" + id + ", nombre=" + nombre + ", direcci�n=" + direcci�n + "]";
}



}
