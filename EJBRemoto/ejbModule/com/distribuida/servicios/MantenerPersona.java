package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.Stateless;

import com.distribuida.entidad.Persona;

@Stateless
public class MantenerPersona implements MantenerPersonaRemote {

	private List<Persona> lista;

	@Override
	public List<Persona> listar(Connection c) {
		lista = null;
		String SQLListar = "SELECT * FROM tpersona";
		Statement stm = null;

		try {

			stm = c.createStatement();
			ResultSet rs = stm.executeQuery(SQLListar);
			if (rs != null) {
				while (rs.next()) {
					Persona p = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("direccion"));
					lista.add(p);
				}
			}
			c.close();
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean crear(Persona p, Connection c) {
		PreparedStatement stm = null;
		boolean isCreate = false;
		try {
			stm = c.prepareStatement("INSERT INTO tpersona VALUES (?,?,?)");
			stm.setInt(1, p.getId());
			stm.setString(2, p.getNombre());
			stm.setString(3, p.getDireccion());
			stm.executeUpdate();
			isCreate = true;
			c.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return isCreate;
	}

	@Override
	public boolean eliminar(int id, Connection c) {
		boolean del=false;
		PreparedStatement stm = null;
		try {
			stm = c.prepareStatement("DELETE FROM tpersona WHERE id = ?");
			stm.setInt(1, id);
			stm.executeUpdate();
			c.close();
			del=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public boolean editar(Persona p, int id, Connection c) {
		boolean update=false;
		PreparedStatement stm = null;
		try {
			stm = c.prepareStatement("UPDATE tpersona SET nombre=?, direccion=?");
			stm.setString(2, p.getNombre());
			stm.setString(3, p.getDireccion());
			stm.executeUpdate();
			c.close();
			update=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public Persona buscar(int id, Connection c) {
		Persona p = null;
		PreparedStatement stm = null;
		try {
			stm = c.prepareStatement("SELECT * FROM tpersona WHERE id = ?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if (rs != null) {
				p = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("direccion"));
				c.close();
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
	
}
