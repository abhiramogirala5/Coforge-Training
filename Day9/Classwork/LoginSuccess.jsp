<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<font color = 'green'><b>Welcome <%=session.getAttribute("username") %></b></font>
	<br>
	<%
		Cookie[] cookies = request.getCookies();
	out.println("<font color='green'><b>Welcome " + cookies[0].getValue() + "</b></font>");
	%>
</body>
</html>