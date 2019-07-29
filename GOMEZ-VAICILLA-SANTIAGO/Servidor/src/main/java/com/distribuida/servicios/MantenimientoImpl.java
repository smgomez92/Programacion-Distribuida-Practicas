package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Component;

import com.distribuida.entidad.Persona;

@Component
public class MantenimientoImpl implements Mantenimiento {

	@Override
	public boolean insertar(Persona p, Connection c) {

		try {
			String SSQL = "INSERT INTO persona (id, identificacion, nombre, fechaNacimiento, direccion) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement psql = c.prepareStatement(SSQL);
			psql.setInt(1, p.getId());
			psql.setString(2, p.getIdentificacion());
			psql.setString(3, p.getNombre());
			psql.setDate(4, p.getFechaNacimiento());
			psql.setString(5, p.getDireccion());

			psql.executeUpdate();

			psql.close();
			return true;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}

	}

	@Override
	public List<Persona> consultar(Connection c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrar(int id, Connection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Persona p, Connection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Persona getPersona(Long id, Connection c) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
}
