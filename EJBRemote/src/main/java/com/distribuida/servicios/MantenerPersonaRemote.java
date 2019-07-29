package com.distribuida.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.distribuida.entidad.Persona;
@Remote
public interface MantenerPersonaRemote {
	 List<Persona>listar ();
	 void crear(Persona p);
	 void eliminar(int id);
	 void editar(Persona p, int id);
	 Persona buscar (int id);
}
