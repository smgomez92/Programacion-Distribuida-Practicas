package com.prueba.distribuida.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.prueba.distribuida.pojos.Persona;



public class PersonaRowMaper implements RowMapper<Persona>{

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Persona(rs.getInt("id"),rs.getString("cedula"),rs.getString("direccion"),rs.getString("tipo"),rs.getString("nombre"));
		
	}

}
