package com.coforge.day5.jdbc;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSelectTest {

	public static void main(String[] args) throws Exception {
		
		// Step 1: Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2: Connection with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Abhiram@007");
		System.out.println("Connection Successful");
		
		// Step 3: Creating Statement
		String sql = "select* from department";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		// Step 4: Executing Query
		while(rs.next()) {
			String s1 = rs.getString(1);
			String s2 = rs.getString(2);
			String s3 = rs.getString(3);
			System.out.println(s1 + " " + s2 + " " + s3);
		}
		
		// Step 5: Closing resources
		rs.close();
		stmt.close();
		connection.close();
	}
}
