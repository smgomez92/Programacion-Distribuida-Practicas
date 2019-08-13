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
		String query = "insert into persona (id,cedula,direccion,tipo,nombre,iddir) values('" + e.getId() + "','" + e.getCedula() + "','" + e.getDireccion()+ "','"+e.getTipoDireccion()
				 + "','"+e.getNombre()+ "','"+e.getIdDir()+ "')";
		jdbcTemplate.update(query);
		return e;
	}
	
	public int updatePersona(Persona e) {
		String query = "update persona set nombre='" + e.getNombre() + "',cedula='" + e.getCedula() + "',tipo='" + e.getTipoDireccion() + "',direccion='" + e.getDireccion()+ "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}


	public int deletePersona(String id) {
		String query = "delete from persona where id='" + id + "' ";
		return jdbcTemplate.update(query);
	}
	
	public List<Persona> findAll() {
		return jdbcTemplate.query("SELECT * FROM persona ORDER BY id", new PersonaRowMaper());
	}
	
	public Persona findByid(String id) {
		List<Persona> persona=jdbcTemplate.query("SELECT * FROM persona WHERE id = '"+id+"'", new PersonaRowMaper());
		
		return persona.size()==0?null:persona.get(0);
	}
	
	

}
