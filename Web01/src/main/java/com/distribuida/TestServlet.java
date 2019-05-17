package com.distribuida;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.distribuida.servicios.HolaMundo;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2551551217906390094L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();

		//ServletContext sc = req.getServletContext();
		//ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
		//Stream.of(context.getBeanDefinitionNames()).forEach(s -> pw.println(s));
		//HolaMundo servicio = context.getBean(HolaMundo.class);
		//pw.println("<h1>" + servicio.hola("TEST") + "</h1>" + " " + sc.getContextPath());
		pw.print("hola "+req.getParameter("user"));
	}

}
