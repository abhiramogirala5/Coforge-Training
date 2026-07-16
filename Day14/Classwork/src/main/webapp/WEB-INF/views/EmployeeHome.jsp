<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<link href = "EMSStyle.css" rel = "stylesheet"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class = "header">
		<h1>Employee Management System</h1>
	</div>
	<br>
	<form action = "employee" method = "post">
	<div class = "content">
		<table>
			<tr>
				<td>Employee ID:</td>
				<td><input type="text" name = "eid"></td>
			</tr>
			<tr>
				<td>Employee Name:</td>
				<td><input type="text" name = "ename"></td>
			</tr>
			
			<tr>
				<td>Employee Salary:</td>
				<td><input type="text" name = "esalary"></td>
			</tr>
			<tr>
				<td>Department Number:</td>
				<td><input type="text" name = "dno"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Insert" name = "Insert" class="btn-primary">&nbsp;&nbsp;
		<input type="submit" value="Delete" name = "Delete" class="btn-danger">&nbsp;&nbsp;
		<input type="submit" value="Update" name = "Update" class = "btn-success">&nbsp;&nbsp;
		<input type="submit" value="Find" name = "Find" class = "btn-info">&nbsp;&nbsp;
		<input type="submit" value="FindAll" name = "FindAll" class = "btn-warning">&nbsp;&nbsp;
		<br>
	</div>
	</form>
	
	<br>
	
	<!-- Expression Language (el) -->
	<div>
		<b>${result}</b>	
	</div>
	
</body>
</html>