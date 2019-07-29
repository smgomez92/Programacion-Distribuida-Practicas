package com.distribuida.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.distribuida.config.ConfigCliente;
import com.distribuida.entidad.Persona;


@WebServlet(urlPatterns = "/ingresar")
public class Ingresar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCliente.class);
		com.distribuida.Mantenimiento servicio = (com.distribuida.Mantenimiento) context.getBean("servicio");

		String nombre = req.getParameter("nombre");
		String id = req.getParameter("id");
		String dir = req.getParameter("direccion");
		String fecha = req.getParameter("fecha");
		
		String identificacion = req.getParameter("identificacion");
		if (nombre != null && nombre != "" && id != null && id != "" && dir != null && dir != "") {
			Persona p = new Persona();
			p.setDireccion(dir);
			p.setIdentificacion(identificacion);
			p.setId(Integer.parseInt(id));
			p.setNombre(nombre);
			if (servicio.insertar(p)) {
				pw.append("<h1>La Persona Ingresada es: </h1>" + "<table>" + "<tr>" + "<td>Cédula:</td>" + "<td>" + id
						+ "</td>" + "</tr>" + "<tr>" + "<td>Nombre:</td>" + "<td>" + p.getNombre() + "</td>" + "<tr>"
						+ "<td>Dirección:</td>" + "<td>" + p.getDireccion() + " </td>" + "</tr>")
						.append("</table><a href=\"menu.jsp\">Regresar</a>");

			} else {

				pw.append("<h1>NO SE HAN INGRESO PERSONA</h1>").append("<a href=\"ingresar.jsp\">Regresar</a>");
			}
		} else {

			pw.append("<h1>NO SE HAN INGRESADO DATOS</h1>").append("<a href=\"ingresar.jsp\">Regresar</a>");

		}

	}

}
