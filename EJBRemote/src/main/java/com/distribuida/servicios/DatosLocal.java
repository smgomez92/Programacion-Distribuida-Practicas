package com.distribuida.servicios;

import java.sql.Connection;

import javax.ejb.Local;


@Local
public interface DatosLocal {
	
	Connection getConexion();

}
