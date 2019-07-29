package com.practica.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.practica.pojo.Empleado;

public class EmpleadoRowMapper implements RowMapper<Empleado> {
	@Override
	public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Empleado(rs.getInt("id"),rs.getString("name"),rs.getFloat("salary"));
	}

}
