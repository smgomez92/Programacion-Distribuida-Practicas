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

@WebServlet(urlPatterns = "/editar")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private Mantenimiento man;
	@Inject
	private Manejador em;

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String id;
		Persona p;
		if((req.getParameter("bandera")==null)) {
			 id = req.getParameter("id");
			 p = man.getPersona(Long.parseLong(id), em.getManejador());
			System.out.println("valor "+req.getParameter("bandera"));
			if (p!=null) {
				req.setAttribute("id", id);
				req.setAttribute("nombre", p.getNombre());
				req.setAttribute("direccion", p.getDireccion());
				req.getRequestDispatcher("/editando.jsp").forward(req, resp);
			} else {
				pw.append("<h1>NO EXISTE ESA PERSONA</h1>").append("<a href=\"editar.jsp\">Regresar</a>");
				
			}
		}else {
			System.out.print(req.getParameter("bandera"));
			id = req.getParameter("id");
			 p= man.getPersona(Long.parseLong(id), em.getManejador());
			 p.setDireccion(req.getParameter("direccion"));
			 p.setNombre(req.getParameter("nombre"));
			 man.actualizar(p, em.getManejador());
			 
			 pw.append("<h1>Persona Editada : </h1>" + "<table>" + "<tr>" + "<td>Cédula:</td>"
						+ "<td>" + id + "</td>" + "</tr>" + "<tr>" + "<td>Nombre:</td>"
						+ "<td>" + p.getNombre()+"</td>" + "<tr>" + "<td>Dirección:</td>"
						+ "<td>" + p.getDireccion()
						+ " </td>" + "</tr>")
						.append("</table><a href=\"menu.jsp\">Regresar al menú</a>");
			
			
		}
	}

}
