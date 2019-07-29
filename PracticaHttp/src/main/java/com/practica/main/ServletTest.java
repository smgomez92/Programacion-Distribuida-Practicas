package com.practica.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practica.config.Config;
import com.practica.servicios.Saludo;
@WebServlet(urlPatterns = "/test")
public class ServletTest extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw =resp.getWriter();
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Saludo servicio = (Saludo)context.getBean("servicio");
		
		pw.append(servicio.hola("SANTIAGO"));
		
	}

}
