package com.distribuida.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.distribuida.config.ConfigCliente;
import com.distribuida.entidad.Persona;
import com.distribuida.mensajes.Productor;

@WebServlet(urlPatterns = "/eliminar")
public class Eliminar extends HttpServlet {
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCliente.class);
		com.distribuida.Mantenimiento servicio = (com.distribuida.Mantenimiento) context.getBean("servicio");
		
		String identificacion = req.getParameter("identificacion");
		Persona p = new Persona();
		p.setIdentificacion(identificacion);
		Productor pr =new Productor();
		
		try {
		pr.create("Borrar");
		pr.borra(p);
		pr.close();
		}catch(Exception e) {
			
			
		}
	}
	
	

}
