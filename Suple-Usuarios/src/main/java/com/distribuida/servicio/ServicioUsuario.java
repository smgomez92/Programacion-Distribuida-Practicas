package com.distribuida.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.distribuida.modelo.Usuario;



@Service
public class ServicioUsuario {
	
		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		
		public Usuario saveUsuario(Usuario e) {
			String query = "insert into usuario (id,nombre,username,email) values('" + e.getId() + "','" + e.getNombre() + "','" + e.getUsername()+ "','"+e.getMail()
					 + "')";
			jdbcTemplate.update(query);
			return e;
		}
		
		//public int updatePersona(Usuario e) {
			//String query = "update persona set nombre='" + e.getNombre() + "',cedula='" + e.getCedula() + "',tipo='" + e.getTipoDireccion() + "',direccion='" + e.getDireccion()+ "' where id='"
				//	+ e.getId() + "' ";
			//return jdbcTemplate.update(query);
		//}


		//public int deletePersona(String id) {
		//	String query = "delete from persona where id='" + id + "' ";
		//	return jdbcTemplate.update(query);
		//}
		
		public List<Usuario> findAll() {
			return jdbcTemplate.query("SELECT * FROM usuario ORDER BY id", new UsuarioRowMapper());
		}
		
		public Usuario findByid(String id) {
			List<Usuario> persona=jdbcTemplate.query("SELECT * FROM persona WHERE id = '"+id+"'", new UsuarioRowMapper());
			
			return persona.size()==0?null:persona.get(0);
		}

}
