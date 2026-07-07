package com.coforge.ems.dao;

import java.sql.*;
import java.util.*;

import com.coforge.ems.model.Employee;
import com.coforge.ems.util.ApplicationProperties;
import com.coforge.ems.util.DBUtil;

public class EmployeeDAO {

	public int createEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.insert);

		statement.setInt(1, employee.getEid());
		statement.setString(2, employee.getEname());
		statement.setInt(3, employee.getEsalary());
		statement.setInt(4, employee.getDon());

		return statement.executeUpdate();
	}

	public int deleteEmployee(int eid) throws ClassNotFoundException, SQLException {

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.delete);

		statement.setInt(1, eid);

		return statement.executeUpdate();
	}

	public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.update);

		statement.setString(1, employee.getEname());
		statement.setInt(2, employee.getEsalary());
		statement.setInt(3, employee.getDon());
		statement.setInt(4, employee.getEid());

		return statement.executeUpdate();
	}

	public List<Employee> findAllEmployees() throws ClassNotFoundException, SQLException {

		List<Employee> list = new ArrayList<>();

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findAll);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			Employee emp = new Employee();

			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setEsalary(rs.getInt("salary"));
			emp.setDon(rs.getInt("dno"));

			list.add(emp);
		}

		return list;
	}

	public Employee findEmployee(int eid) throws ClassNotFoundException, SQLException {

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.find);

		statement.setInt(1, eid);

		ResultSet rs = statement.executeQuery();

		Employee emp = null;

		if (rs.next()) {

			emp = new Employee();

			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setEsalary(rs.getInt("salary"));
			emp.setDon(rs.getInt("dno"));
		}

		return emp;
	}

}