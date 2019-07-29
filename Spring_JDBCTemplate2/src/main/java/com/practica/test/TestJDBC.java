package com.practica.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practica.config.ConfigJDBC;
import com.practica.pojo.Empleado;
import com.practica.servicios.EmpleadoDao;

public class TestJDBC {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigJDBC.class);
		EmpleadoDao emp = ctx.getBean("empleadoDaoImpl", EmpleadoDao.class);
		//int status = emp.saveEmployee(new Empleado(5, "La prueba alv", 80000));
		System.out.println(emp.updateEmployee(new Empleado(5,"Sepuede ir mucho alv",100000))==1?"se modificó alv":"no se modificó :(");
		List<Empleado> listado = emp.findAll();
		for(Empleado p : listado) {
			System.out.println(p);
			
		}
		//System.out.println(status == 1 ? "se insertó" : "no se insertó");
		// impresión de beans
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

	}
}
