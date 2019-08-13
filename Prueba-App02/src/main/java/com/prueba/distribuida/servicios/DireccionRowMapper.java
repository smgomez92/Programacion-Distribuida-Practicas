package com.prueba.distribuida.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.prueba.distribuida.pojos.Direccion;



public class DireccionRowMapper implements RowMapper<Direccion> {

	@Override
	public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Direccion(rs.getInt("id"), rs.getString("descripcion"));

	}

}