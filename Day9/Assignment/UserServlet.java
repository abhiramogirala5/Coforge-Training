package com.coforge.servelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
        String email=request.getParameter("email");

        request.setAttribute("name", name);
        request.setAttribute("email", email);

        RequestDispatcher dispatch=request.getRequestDispatcher("UserOutput.jsp");

        dispatch.forward(request, response);
	}

}
