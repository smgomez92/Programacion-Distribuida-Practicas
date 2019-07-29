package com.distribuida.servicios;

import java.sql.Connection;

import javax.ejb.Stateless;

@Stateless
public class Datos implements DatosLocal{
	@Override
	public Connection getConexion() {
		// TODO Auto-generated method stub
		return null;
	}

}
