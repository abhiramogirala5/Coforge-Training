<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Assignment</title>

<style>
body {
    font-family: Arial, sans-serif;
    margin: 30px;
}

h2 {
    color: blue;
}

table {
    border-collapse: collapse;
    margin-top: 10px;
}

table, th, td {
    border: 1px solid black;
    padding: 8px;
    text-align: center;
}
</style>

<%!
    // Declaration
    int number = 5;

    public int square(int n) {
        return n * n;
    }
%>

</head>

<body>

    <h2>1. Welcome Message</h2>
    <h3>Welcome to JSP</h3>

    <hr>

    <h2>2. Current Date and Time</h2>
    <p>
        Current Date and Time:
        <%= new Date() %>
    </p>

    <hr>

    <h2>3. JSP Scripting Elements</h2>

    <h3>Declaration</h3>
    <p>
        Declared Number = <%= number %>
    </p>

    <h3>Scriptlet</h3>

    <%
        int a = 10;
        int b = 20;
        int sum = a + b;
    %>

    <p>
        Using Scriptlet, Sum = <%= sum %>
    </p>

    <h3>Expression</h3>

    <p>
        Square of <%= number %> = <%= square(number) %>
    </p>

    <hr>

    <h2>4. Multiplication Table of 5</h2>

    <table>
        <tr>
            <th>Expression</th>
            <th>Result</th>
        </tr>

        <%
            for (int i = 1; i <= 10; i++) {
        %>

        <tr>
            <td>5 x <%= i %></td>
            <td><%= 5 * i %></td>
        </tr>

        <%
            }
        %>

    </table>

</body>
</html>