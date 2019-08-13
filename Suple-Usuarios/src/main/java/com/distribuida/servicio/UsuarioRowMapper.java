package com.distribuida.servicio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.distribuida.modelo.Usuario;



public class UsuarioRowMapper implements RowMapper<Usuario>{
	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Usuario(rs.getInt("id"),rs.getString("nombre"),rs.getString("username"),rs.getString("mail"));
		
	}

}
