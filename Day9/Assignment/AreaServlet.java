package com.coforge.servelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AreaServlet
 */
@WebServlet("/AreaServlet")
public class AreaServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double radius =(Double) request.getAttribute("radius");

		double area = 3.14 * radius * radius;

		request.setAttribute("area", area);

		RequestDispatcher dispatch = request.getRequestDispatcher("CircleOutput.jsp");

			dispatch.forward(request, response);
	}

}
