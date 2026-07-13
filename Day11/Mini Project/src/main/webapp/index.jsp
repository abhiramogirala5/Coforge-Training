<%@ page import="java.util.List"%>
<%@ page import="com.coforge.ems.model.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<script src="AjaxScript.js"></script>

<link href="EMSStyle.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>

	<div class="header">
		<h1>Employee Management System</h1>
	</div>

	<br>

	<div class="content">

		<form action="EmployeeController" method="post">

			<table>

				<tr>
					<td><input type="text" id = "eid" name="eid" placeholder="Employee ID" onblur = "getEmployeeDetails()"
						value="<%=request.getParameter("eid") == null ? "" : request.getParameter("eid")%>">
					</td>
				</tr>

				<tr>
					<td><input type="text" id = "ename" name="ename"
						placeholder="Employee Name"
						value="<%=request.getParameter("ename") == null ? "" : request.getParameter("ename")%>">
					</td>
				</tr>

				<tr>
					<td><input type="text" id = "salary" name="salary" placeholder="Salary"
						value="<%=request.getParameter("salary") == null ? "" : request.getParameter("salary")%>">
					</td>
				</tr>

				<tr>
					<td><input type="text" id = "dno" name="dno" placeholder="Department No"
						value="<%=request.getParameter("dno") == null ? "" : request.getParameter("dno")%>">
					</td>
				</tr>

			</table>

			<br> <input type="submit" value="Insert" class="btn btn-primary"
				name="emsButton"> <input type="submit" value="Delete"
				class="btn btn-danger" name="emsButton"> <input
				type="submit" value="Update" class="btn btn-warning"
				name="emsButton"> <input type="submit" value="Find"
				class="btn btn-success" name="emsButton"> <input
				type="submit" value="FindAll" class="btn btn-info" name="emsButton">

		</form>
		</div>

		<br>

		<div class="alert alert-primary">

			<b>Result :</b>

			<pre>
<%=request.getParameter("result") == null ? "" : request.getParameter("result")%>
</pre>

		</div>
</body>
</html>