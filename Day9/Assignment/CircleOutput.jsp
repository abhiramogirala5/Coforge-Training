<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="CircleInput.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Area of Circle</h3>

    Radius :<%= request.getAttribute("radius") %>

	<br><br>

	Area :<%= request.getAttribute("area") %>
	
</body>
</html>