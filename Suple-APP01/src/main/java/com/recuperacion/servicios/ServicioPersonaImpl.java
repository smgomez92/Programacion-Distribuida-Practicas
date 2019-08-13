package com.recuperacion.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.recuperacion.modelo.Persona;
import com.recuperacion.repositorio.RepoPersona;

@Named
public class ServicioPersonaImpl implements ServicioPersona{
	
	@Inject
	RepoPersona repo;

	@Override
	public void crearPersona(Persona persona) {
		repo.persist(persona);
		
	}

	@Override
	public void editarPersona(Persona persona) {
		repo.update(persona);
		
	}

	@Override
	public List<Persona> listar() {
		
		return repo.list();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		
		return repo.findById(id);
	}

	@Override
	public void eliminarPersona(Persona persona) {
		repo.delete(persona);
		
	}

}
