package com.distribuida.restserver.servicios;

import java.util.List;

import com.distribuida.restserver.dto.Persona;

public interface ServicioPersona {
	public Persona buscar(int id);
	public Persona crear(Persona p);
	public void eliminar(int id);
	public Persona editar(Persona p);
	public List<Persona> listar();
}
