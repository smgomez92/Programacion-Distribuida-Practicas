package com.distribuida.modelo;

public class ListaPost {
	
	private Usuario user;
	private Post post;
	private Coment coment;
	
	
	public ListaPost(Usuario user, Post post, Coment coment) {
		
		this.user = user;
		this.post = post;
		this.coment = coment;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Coment getComent() {
		return coment;
	}
	public void setComent(Coment coment) {
		this.coment = coment;
	}
	
	

}
