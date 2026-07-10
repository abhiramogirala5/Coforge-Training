package com.coforge.servelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	request.setAttribute("message","Hello World! Welcome to Servlets");

	        RequestDispatcher dispatcher =request.getRequestDispatcher("HelloOutput.jsp");

	        dispatcher.forward(request, response);
	}

}
