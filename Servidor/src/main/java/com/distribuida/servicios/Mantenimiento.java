package com.distribuida.servicios;

import java.sql.Connection;
import java.util.List;



import com.distribuida.entidad.Persona;

public interface Mantenimiento {
	
	public boolean insertar(Persona p, Connection c);
	public List<Persona> consultar(Connection c);
	public boolean borrar(int id,Connection c);
	public boolean actualizar(Persona p,Connection c );
	public Persona getPersona(Long id,Connection c);	
		
	
}
