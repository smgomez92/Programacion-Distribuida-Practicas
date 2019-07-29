package com.practica.data;

import org.springframework.jdbc.core.JdbcTemplate;

import com.practica.pojos.Empleado;

public class EmpleadoDao {
	
		private JdbcTemplate jdbcTemplate;  
		  
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		    this.jdbcTemplate = jdbcTemplate;  
		}  
		  
		public int saveEmployee(Empleado e){  
		    String query="insert into empleado values('"+e.getId()+"','"+e.getNombre()+"','"+e.getSalario()+"')";  
		    return jdbcTemplate.update(query);  
		}  
		public int updateEmployee(Empleado e){  
		    String query="update empleado set name='"+e.getNombre()+"',salary='"+e.getSalario()+"' where id='"+e.getId()+"' ";  
		    return jdbcTemplate.update(query);  
		}  
		public int deleteEmployee(Empleado e){  
		    String query="delete from empleado where id='"+e.getId()+"' ";  
		    return jdbcTemplate.update(query);  
		}  
		  
		
}
