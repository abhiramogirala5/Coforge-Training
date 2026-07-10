package com.coforge.servelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RadiusServlet
 */
@WebServlet("/RadiusServlet")
public class RadiusServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double radius = Double.parseDouble(request.getParameter("radius"));

		request.setAttribute("radius", radius);

		RequestDispatcher dispatch = request.getRequestDispatcher("AreaServlet");

		dispatch.forward(request, response);
	}

}
