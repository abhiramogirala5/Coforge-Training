package com.coforge.ems.util;

public class ApplicationProperties {

	// Database Connection

	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/ems";
	public static final String userId = "root";
	public static final String password = "Abhiram@007";

	// SQL Queries

	public static final String insert = "insert into tbl_employee values(?,?,?,?)";

	public static final String update = "update tbl_employee set ename=?, salary=?, dno=? where eid=?";

	public static final String delete = "delete from tbl_employee where eid=?";

	public static final String find = "select * from tbl_employee where eid=?";

	public static final String findAll = "select * from tbl_employee";

	// Responses

	public static final String insertSuccess = "SUCCESS : Employee Inserted Successfully";
	
	public static final String deleteSuccess = "SUCCESS : Employee Deleted Successfully";
	
	public static final String updateSuccess = "SUCESS : Employee Details Updated Sucessfully";
	
	public static final String findSuccess = "SUCESS : Employee Details Found";
	
	public static final String findAllSuccess = "SUCESS : Employee Details";

	public static final String dbFail = "FAILED : Database Error";

	public static final String validationFailed = "FAILED : Invalid Employee Details";
}