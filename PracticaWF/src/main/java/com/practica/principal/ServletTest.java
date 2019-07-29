package com.practica.principal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practica.ejbs.HolaLocal;
@WebServlet(urlPatterns = "/test")
public class ServletTest extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	HolaLocal hm; 
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw =resp.getWriter();
		String res =hm.hola("Santiago");		
		pw.print(res);		
	}
}
