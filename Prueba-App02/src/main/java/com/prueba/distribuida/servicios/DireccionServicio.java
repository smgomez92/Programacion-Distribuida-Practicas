package com.prueba.distribuida.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.prueba.distribuida.pojos.Direccion;



@Service
public class DireccionServicio {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Direccion savePerson(Direccion e) {
		String query = "insert into persona values('" + e.getId() + "','" + e.getDescripcion()+"')";
		jdbcTemplate.update(query);
		return e;
	}
	
	public int updatePersona(Direccion e) {
		String query = "update persona set name='" + e.getDescripcion() + "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}


	public int deletePersona(Direccion e) {
		String query = "delete from direccion where id='" + e.getId() + "' ";
		return jdbcTemplate.update(query);
	}
	
	public List<Direccion> findAll() {
		return jdbcTemplate.query("SELECT * FROM direccion", new DireccionRowMapper());
	}
	
	public Direccion findByid(String id) {
		List<Direccion> direccion=jdbcTemplate.query("SELECT * FROM direccion WHERE id = '"+id+"'", new DireccionRowMapper());
		
		return direccion.size()==0?null:direccion.get(0);
	}
	
		 
}
