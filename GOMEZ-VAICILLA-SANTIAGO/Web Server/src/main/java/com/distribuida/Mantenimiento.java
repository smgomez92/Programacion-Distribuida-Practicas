package com.distribuida;

import java.sql.Connection;
import java.util.List;

import com.distribuida.entidad.Persona;

public interface Mantenimiento {
	public boolean insertar(Persona p);
	public List<Persona> consultar();
	public boolean borrar(Long id);
	public boolean actualizar(Persona p );
	public Persona getPersona(Long id);	
}
