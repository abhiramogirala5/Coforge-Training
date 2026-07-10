package com.coforge.servelt.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailCheckServelt")
public class EmailCheckServelt extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email"); // corrected

        if (email != null && email.equals("abhi@gmail.com")) {
            out.println("<font color='green'>Valid Email</font>");
        } else {
            out.println("<font color='red'>Invalid Email</font>");
        }
    }
}