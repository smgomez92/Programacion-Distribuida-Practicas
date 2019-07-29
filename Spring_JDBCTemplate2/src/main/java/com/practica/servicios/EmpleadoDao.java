package com.practica.servicios;

import java.util.List;

import com.practica.pojo.Empleado;

public interface EmpleadoDao {
	public int saveEmployee(Empleado e);

	public int updateEmployee(Empleado e);

	public int deleteEmployee(Empleado e);
	
	public List<Empleado> findAll();
}
