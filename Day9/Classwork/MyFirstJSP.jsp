<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP Declaration Tag --%>
	<%! 
		String name = "Abhi";
		int a = 10 , b = 20;
	%>
	
	<%-- JSP Scriptlet Tag --%>
	<%
		out.println("<br>Welcome" + name);
		if(a > b) {
			out.println("<br>a is Big Element");
		}else {
			out.println("<br>b is Big Element");
		}
		int sum = a + b;
	%>
	<br>
	<%-- JSP Expression Tag --%>
	sum = <%=sum %>
</body>
</html>