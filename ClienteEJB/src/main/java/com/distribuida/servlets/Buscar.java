package com.distribuida.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.NoInitialContextException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.pojo.Persona;
import com.distribuida.servicios.MantenerPersonaRemote;




@WebServlet(urlPatterns = "/buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");		

		PrintWriter pw = resp.getWriter();

		if (id != null && id != "") {
			Persona p = man().buscar(Integer.parseInt(id), getConexion());
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
	
	
	public MantenerPersonaRemote man() {
		MantenerPersonaRemote miejb = null;
		try {

			Properties jndiProperties = new Properties();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			jndiProperties.put("jboss.naming.client.ejb.context", true);
			jndiProperties.put(Context.SECURITY_PRINCIPAL, "SMGOMEZ");
			jndiProperties.put(Context.SECURITY_CREDENTIALS, "Santy_172167");
			Context context = new InitialContext(jndiProperties);
			miejb = (MantenerPersonaRemote) context
					.lookup("EJBRemoto/MantenerPersona!com.distribuida.servicios.MantenerPersonaRemote");
			return miejb;

		} catch (NoInitialContextException e) {

			e.printStackTrace();

		}

		catch (NamingException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return miejb;
	}

	public Connection getConexion() {
		Connection connection = null;
		try {

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Examen", "postgres", "admin");

			boolean valid = connection.isValid(50000);
			System.out.println(valid ? "TEST OK" : "TEST FAIL");
			return connection;
		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
		}
		return connection;
	}
}
