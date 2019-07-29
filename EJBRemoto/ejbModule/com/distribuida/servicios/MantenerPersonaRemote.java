package com.distribuida.servicios;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Remote;

import com.distribuida.entidad.Persona;
@Remote
public interface MantenerPersonaRemote {
	 List<Persona>listar (Connection c);
	 boolean crear(Persona p,Connection c);
	 boolean eliminar(int id,Connection c);
	 boolean editar(Persona p, int id,Connection c);
	 Persona buscar (int id,Connection c);
	 
}
