package com.distribuida.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.distribuida.entidad.Persona;
@Stateless
public class MantenerPersona implements MantenerPersonaRemote {
	@EJB
	private Datos con;	
	

	@Override
	public List<Persona> listar() {
		con.getConexion();
		return null;
	}

	@Override
	public void crear(Persona p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Persona p, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
