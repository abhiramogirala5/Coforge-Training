package com.coforge.servelts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServelt
 */
@WebServlet("/MyFirstServelt")
public class MyFirstServelt extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //Response from Server to Client
		out.println("<font><h1>Welcome To Servelt</h1></font>");
		out.close();
	}
}
