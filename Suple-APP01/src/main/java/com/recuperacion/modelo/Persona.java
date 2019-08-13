package com.recuperacion.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "cedula")
	private String cedula;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "tipodireccion")
	private String tipoDireccion;

	@Column(name = "iddir")
	private String idDir;

	public Persona() {

	}

	public Persona(int id, String cedula, String direccion, String nombre, String tipoDireccion, String idDir) {
		this.id = id;
		this.cedula = cedula;
		this.direccion = direccion;
		this.nombre = nombre;
		this.tipoDireccion = tipoDireccion;
		this.idDir = idDir;
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

	public String getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public String getIdDir() {
		return idDir;
	}

	public void setIdDir(String idDir) {
		this.idDir = idDir;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", cedula=" + cedula + ", direccion=" + direccion + ", nombre=" + nombre
				+ ", tipoDireccion=" + tipoDireccion + ", idDir=" + idDir + "]";
	}

}
