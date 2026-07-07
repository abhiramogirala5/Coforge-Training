package com.coforge.ems.controller;

import java.sql.SQLException;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

public class EmployeeController {

	private EmployeeService service = new EmployeeService();

	public String createEmployee(Employee employee) {

		try {

			if (service.createEmployee(employee) == 1)
				return ApplicationProperties.insertSuccess;

		} catch (ClassNotFoundException | SQLException e) {

			return ApplicationProperties.dbFail;

		} catch (InvalidEmployeeObjectException e) {

			return e.toString();
		}

		return "Failed";
	}

	public String updateEmployee(Employee employee) {

		try {

			if (service.updateEmployee(employee) == 1)
				return "SUCCESS : Employee Updated";

			return "Employee Not Found";

		} catch (Exception e) {

			return e.toString();
		}
	}

	public String deleteEmployee(int eid) {

		try {

			if (service.deleteEmployee(eid) == 1)
				return "SUCCESS : Employee Deleted";

			return "Employee Not Found";

		} catch (Exception e) {

			return e.toString();
		}
	}

	public String findAllEmployee() {

		try {

			return service.findAllEmployees().toString();

		} catch (Exception e) {

			return ApplicationProperties.dbFail;
		}
	}

	public String findEmployee(int eid) {

		try {

			Employee emp = service.findEmployee(eid);

			if (emp != null)
				return emp.toString();

			return "Employee Not Found";

		} catch (Exception e) {

			return e.toString();
		}
	}

}
