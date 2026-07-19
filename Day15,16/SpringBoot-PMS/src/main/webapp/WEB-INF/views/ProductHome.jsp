<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ page import="com.coforge.pms.model.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management System</title>

<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>

<h2 align="center">Product Management System</h2>

<form action="product" method="post">

<table align="center">

<tr>
<td>Product ID</td>
<td><input type="text" name="pid"></td>
</tr>

<tr>
<td>Product Name</td>
<td><input type="text" name="productName"></td>
</tr>

<tr>
<td>Price</td>
<td><input type="text" name="productPrice"></td>
</tr>

<tr>
<td>Quantity</td>
<td><input type="text" name="productQuantity"></td>
</tr>

</table>

<br>

<center>

<input type="submit" name="Insert" value="Insert" class="btn btn-primary">

<input type="submit" name="Delete" value="Delete" class="btn btn-danger">

<input type="submit" name="Update" value="Update" class="btn btn-success">

<input type="submit" name="Find" value="Find" class="btn btn-info">

<input type="submit" name="FindAll" value="FindAll" class="btn btn-warning">

</center>

</form>

<br>

<div align="center">
<b>${result}</b>
</div>

<%
Product product=(Product)request.getAttribute("product");

if(product!=null){
%>

<table class="table table-bordered" width="60%" align="center">

<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Quantity</th>
</tr>

<tr>
<td><%=product.getpid()%></td>
<td><%=product.getProductName()%></td>
<td><%=product.getProductPrice()%></td>
<td><%=product.getProductQuantity()%></td>
</tr>

</table>

<%
}
%>

<%
List<Product> list=(List<Product>)request.getAttribute("list");

if(list!=null){
%>

<table class="table table-striped table-bordered" width="80%" align="center">

<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Quantity</th>
</tr>

<%
for(Product p:list){
%>

<tr>

<td><%=p.getpid()%></td>

<td><%=p.getProductName()%></td>

<td><%=p.getProductPrice()%></td>

<td><%=p.getProductQuantity()%></td>

</tr>

<%
}
%>

</table>

<%
}
%>

</body>
</html>