package com.distribuida.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.entidad.Persona;
import com.distribuida.servicios.Manejador;
import com.distribuida.servicios.Mantenimiento;

@WebServlet(urlPatterns = "/listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private Mantenimiento man;
	@Inject
	private Manejador em;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		List<Persona> lista = man.consultar(em.getManejador());

		if (lista.size()!=0) {
			pw.println("<table border='1'>");
			pw.println("<tr>");
			pw.println(" <th>ID</th>");
			pw.println("<th>NOMBRE</th>");
			pw.println("<th>DIRECCION</th>");

			pw.println(" </tr>");
			for (Persona p : lista) {				
				pw.println("<tr>");
				pw.println("<td>" + p.getId() + "</td>");
				pw.println("<td>" + p.getNombre() + "</td>");
				pw.println("<td>" + p.getDireccion() + "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("<a href=\"menu.jsp\">Regresar</a>");

		} else {
			pw.append("<h1>NO SE HAN ENCONTRADO DATOS</h1>").append("<a href=\"menu.jsp\">Regresar</a>");
		}

	}
}
