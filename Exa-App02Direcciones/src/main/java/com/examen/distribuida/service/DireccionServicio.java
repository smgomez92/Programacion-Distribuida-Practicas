package com.examen.distribuida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.examen.distribuida.direcciones.Direccion;



@Service
public class DireccionServicio {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
		 
}
