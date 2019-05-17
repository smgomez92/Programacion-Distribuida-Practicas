package com.distribuida.servicios;

import java.util.List;

import javax.persistence.EntityManager;

import com.distribuida.entidad.Persona;

public interface Mantenimiento {
	
	public boolean insertar(Persona p, EntityManager em);
	public List<Persona> consultar(EntityManager em);
	public boolean borrar(Long id,EntityManager em);
	public boolean actualizar(Persona p,EntityManager em);
	public Persona getPersona(Long id,EntityManager em);	
		
	
}
