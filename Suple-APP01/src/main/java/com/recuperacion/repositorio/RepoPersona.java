package com.recuperacion.repositorio;

import java.util.List;

import javax.ejb.Local;

import com.recuperacion.modelo.Persona;

@Local
public interface RepoPersona {
	void persist(Persona persona);

	void update(Persona persona);

	void delete(Persona persona);

	List<Persona> list();

	Persona findById(Integer id);
}
