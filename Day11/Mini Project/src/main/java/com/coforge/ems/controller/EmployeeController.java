package com.coforge.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private EmployeeService service = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int eid = Integer.parseInt(request.getParameter("eid"));
		
		PrintWriter out = response.getWriter();
		String res = "";
		
		try {
			Employee employee = service.findEmployee(eid);
			if(employee != null) {
			res = employee.getEname() + " " + employee.getEsalary() + " " + employee.getDon();
			out.println(res);
			}else {
				res = "null 0 0";
				out.println(res);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmployeeObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("emsButton");

		int eid = 0;
		String ename = "";
		int salary = 0;
		int dno = 0;

		Employee employee = null;
		String res = "";

		switch (action) {

		case "Insert":

			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			salary = Integer.parseInt(request.getParameter("salary"));
			dno = Integer.parseInt(request.getParameter("dno"));

			employee = new Employee(eid, ename, salary, dno);

			try {

				int n = service.createEmployee(employee);

				if (n == 1)
					res = ApplicationProperties.insertSuccess;
				else
					res = "Employee Not Inserted";

			} catch (ClassNotFoundException | SQLException e) {

				res = ApplicationProperties.dbFail;

			} catch (InvalidEmployeeObjectException e) {

				res = ApplicationProperties.validationFailed;
			}

			response.sendRedirect("index.jsp?result=" + URLEncoder.encode(res, "UTF-8"));
			break;

		case "Delete":

			eid = Integer.parseInt(request.getParameter("eid"));

			try {

				int n = service.deleteEmployee(eid);

				if (n == 1)
					res = ApplicationProperties.deleteSuccess;
				else
					res = "Employee Not Found";

			} catch (ClassNotFoundException | SQLException e) {

				res = ApplicationProperties.dbFail;

			} catch (InvalidEmployeeObjectException e) {

				res = ApplicationProperties.validationFailed;
			}

			response.sendRedirect("index.jsp?result=" + URLEncoder.encode(res, "UTF-8"));
			break;

		case "Update":

			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			salary = Integer.parseInt(request.getParameter("salary"));
			dno = Integer.parseInt(request.getParameter("dno"));

			employee = new Employee(eid, ename, salary, dno);

			try {

				int n = service.updateEmployee(employee);

				if (n == 1)
					res = ApplicationProperties.updateSuccess;
				else
					res = "Employee Not Updated";

			} catch (ClassNotFoundException | SQLException e) {

				res = ApplicationProperties.dbFail;

			} catch (InvalidEmployeeObjectException e) {

				res = ApplicationProperties.validationFailed;
			}

			response.sendRedirect("index.jsp?result=" + URLEncoder.encode(res, "UTF-8"));
			break;

		case "Find":

			eid = Integer.parseInt(request.getParameter("eid"));

			try {

				res = service.findEmployee(eid).toString();

			} catch (ClassNotFoundException | SQLException e) {

				res = ApplicationProperties.dbFail;

			} catch (InvalidEmployeeObjectException e) {

				res = ApplicationProperties.validationFailed;

			} catch (NullPointerException e) {

				res = "Employee Not Found";
			}

			response.sendRedirect("index.jsp?result=" + URLEncoder.encode(res, "UTF-8"));
			break;

		case "FindAll":

			try {

				StringBuilder sb = new StringBuilder();

				for (Employee emp : service.findAllEmployees()) {

					sb.append(emp).append("\n\n");
				}

				res = sb.toString();

				if (res.isEmpty()) {
					res = "No Employees Found";
				}

			} catch (ClassNotFoundException | SQLException e) {

				res = ApplicationProperties.dbFail;
			}

			response.sendRedirect("index.jsp?result=" + URLEncoder.encode(res, "UTF-8"));
			break;
		}
	}
}