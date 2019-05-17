package com.distribuida.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.distribuida.servicios.Manejador;
import com.distribuida.servicios.Mantenimiento;

@WebServlet(urlPatterns = "/eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private Mantenimiento man;
	@Inject
	private Manejador em;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("id");
		
		if(id!=null && id !="") {
			
			if(man.borrar(Long.parseLong(id), em.getManejador())) {
				pw.append("<h1>PERSONA CON ID: "+id+" BORRADA</h1>").append("<a href=\"menu.jsp\">Menú</a>");
			
		}else {
			pw.append("<h1>NO EXISTE ESA PERSONA</h1>").append("<a href=\"eliminar.jsp\">Regresar</a>");
			
			
		}
		
	}else {
		pw.append("<h1>NO SE HAN INGRESADO DATOS</h1>").append("<a href=\"eliminar.jsp\">Regresar</a>");
	}
	}
}
	

	

