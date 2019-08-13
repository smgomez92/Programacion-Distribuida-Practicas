package com.distribuida.modelo;

public class Usuario {
	private int id;
	private String nombre;
	private String username;
	private String mail;
	private int postId;

	public Usuario() {
	}

	public Usuario(int id, String nombre, String username, String mail,int postId) {
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.mail = mail;
		this.postId=postId;
	}
	
	
	

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", mail=" + mail + "]";
	}

}
