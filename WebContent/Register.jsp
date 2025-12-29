<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> student app</title>
</head>
<body>

<div><h2>Student Registration</h2></div>

<form action="register" method="post">
<table><tr><td>
    Name: </td><td><input type="text" name="name" required ></td></tr>
   <tr><td> Email: </td><td><input type="email" name="email" ></td><tr>
    <tr><td>Year: </td><td><input type="number" name="year" ></td></tr>
    <tr><td></td><td> <input type="submit" value="Register"></td><tr>
    </table>
</form>

<a href="ShowAll"> View All Students</a>
</body>
</html>