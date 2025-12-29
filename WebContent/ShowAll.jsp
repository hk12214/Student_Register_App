<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
</head>
<body>
<h2>Registered Students</h2>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Year</th>
    </tr>

<%
    List<Student> students = (List<Student>) request.getAttribute("Students");
    for (Student s : students) {
%>
    <tr>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getYear() %></td>
    </tr>
<%
    }
%>
</table>

<a href="Register.jsp">Register New Student</a>
</body>
</html>
