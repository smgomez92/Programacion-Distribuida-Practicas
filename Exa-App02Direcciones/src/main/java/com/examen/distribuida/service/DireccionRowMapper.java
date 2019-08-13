package com.examen.distribuida.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.examen.distribuida.direcciones.Direccion;

public class DireccionRowMapper implements RowMapper<Direccion> {

	@Override
	public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Direccion(rs.getInt("id"), rs.getString("descripcion"));

	}

}