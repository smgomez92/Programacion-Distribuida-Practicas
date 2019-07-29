package com.practica.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practica.pojo.Empleado;

@Repository
public class EmpleadoDaoImpl implements EmpleadoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveEmployee(Empleado e) {
		String query = "insert into empleado values('" + e.getId() + "','" + e.getNombre() + "','" + e.getSalario()
				+ "')";
		return jdbcTemplate.update(query);
	}

	@Override
	public int updateEmployee(Empleado e) {
		String query = "update empleado set name='" + e.getNombre() + "',salary='" + e.getSalario() + "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	@Override
	public int deleteEmployee(Empleado e) {
		String query = "delete from empleado where id='" + e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM empleado", new EmpleadoRowMapper());
	}

}
