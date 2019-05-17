package com.distribuida.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.entidad.Persona;
import com.distribuida.servicios.Manejador;
import com.distribuida.servicios.Mantenimiento;

@WebServlet(urlPatterns = "/buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private Mantenimiento man;
	@Inject
	private Manejador em;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");		

		PrintWriter pw = resp.getWriter();

		if (id != null && id != "") {
			Persona p = man.getPersona(Long.parseLong(id), em.getManejador());
			if(p!=null) {
				pw.append("<h1>Persona encontrada: </h1>" + "<table>" + "<tr>" + "<td>Cédula:</td>"
						+ "<td>" + id + "</td>" + "</tr>" + "<tr>" + "<td>Nombre:</td>"
						+ "<td>" + p.getNombre()+"</td>" + "<tr>" + "<td>Dirección:</td>"
						+ "<td>" + p.getDireccion()
						+ " </td>" + "</tr>")
						.append("</table><a href=\"menu.jsp\">Regresar</a>");
				
			}else {
				pw.append("<h1>NO EXISTE ESA PERSONA</h1>").append("<a href=\"buscar.jsp\">Regresar</a>");
				
			}
			
			
			

		} else {

			pw.append("<h1>NO SE HAN INGRESADO DATOS</h1>").append("<a href=\"buscar.jsp\">Regresar</a>");

		}

	}
}
