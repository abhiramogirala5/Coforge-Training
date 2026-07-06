package com.coforge.day5.jdbc;

import java.sql.Connection;
import java.sql.*;

public class JdbcUpdateTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Step - 1 Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step - 2 Connection with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","Abhiram@007");
		System.out.println("Connection Successfull");
		
		//Step - 3 Creating Statement
		String sql = "UPDATE department SET Location = ?, DeptName = ? WHERE DeptID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//Step - 4 Executing Query
		statement.setString(1, "Hyderabad");
		statement.setString(2, "HR");
		statement.setInt(3, 105);
		
		int n = statement.executeUpdate(); //Insert , Delete & Update
		if(n == 1) {
			System.out.println("Employee Details Saved");
		}else {
			System.out.println("Error Occured");
		}
		
		//Step - 5 Closing
		statement.close();
		connection.close();
		
		
	}

}
