package com.distribuida;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		String nombre = req.getParameter("user");
		pw.write("<h1>HOLA "+nombre+"</h1>");
		pw.write("<form action=\"test\" method=\"get\" >");
		pw.write("<input type= \"submit\" />");
		pw.write("<form/>");
		 
	}
	

}
