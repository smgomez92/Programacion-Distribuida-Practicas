package com.examen.distribuida.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.examen.distribuida.pojos.Persona;
import com.examen.distribuida.repository.PersonaRowMaper;


@Service
public class ServicioPersona {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Persona savePerson(Persona e) {
		String query = "insert into persona values('" + e.getId() + "','" + e.getNombre() + "','" + e.getCedula()+ "','"+e.getDireccion().getDescripcion()
				 + "','"+e.getTipoDireccion()+ "')";
		jdbcTemplate.update(query);
		return e;
	}
	
	public int updatePersona(Persona e) {
		String query = "update persona set name='" + e.getNombre() + "',cedula='" + e.getCedula() + "',tipoDireccion='" + e.getTipoDireccion() + "',direccion='" + e.getDireccion().getDescripcion()+ "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}


	public int deletePersona(Persona e) {
		String query = "delete from persona where id='" + e.getId() + "' ";
		return jdbcTemplate.update(query);
	}
	
	public List<Persona> findAll() {
		return jdbcTemplate.query("SELECT * FROM empleado", new PersonaRowMaper());
	}
	
	

}
