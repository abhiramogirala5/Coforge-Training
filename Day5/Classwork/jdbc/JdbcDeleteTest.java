package com.coforge.day5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDeleteTest {

	public static void main(String[] args) throws Exception {
		
		// Step 1: Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2: Connection with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Abhiram@007");
		System.out.println("Connection Successful");
		
		// Step 3: Creating Statement
		String sql = "DELETE FROM department WHERE DeptID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// Step 4: Executing Query
		statement.setInt(1, 105);
		
		int n = statement.executeUpdate();
		
		if (n > 0) {
			System.out.println("Department Deleted Successfully");
		} else {
			System.out.println("No record found");
		}
		
		// Step 5: Closing resources
		statement.close();
		connection.close();
	}
}
