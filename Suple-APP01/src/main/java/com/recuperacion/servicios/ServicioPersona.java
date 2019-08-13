package com.recuperacion.servicios;

import java.util.List;

import com.recuperacion.modelo.Persona;

public interface ServicioPersona {
	void crearPersona(Persona persona);

	void editarPersona(Persona persona);

	List<Persona> listar();

	Persona buscarPorId(Integer id);

	void eliminarPersona(Persona persona);

}
