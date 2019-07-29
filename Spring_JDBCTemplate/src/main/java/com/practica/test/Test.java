package com.practica.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practica.data.EmpleadoDao;
import com.practica.pojos.Empleado;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
	      
	    EmpleadoDao dao=(EmpleadoDao)ctx.getBean("edao");  
	    //int status=dao.saveEmployee(new Empleado(3,"José", 500));  
	    //System.out.println(status);  
	          
	   // int status=dao.updateEmployee(new Empleado(1,"Mauricio",15000)); 
	    //System.out.println(status); 
	    
	          
	    Empleado e=new Empleado(); 
	    e.setId(1); 
	    int status=dao.deleteEmployee(e); 
	    System.out.println(status); 
	      

	}

}
