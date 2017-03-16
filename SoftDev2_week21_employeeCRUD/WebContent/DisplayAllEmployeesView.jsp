<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
	
	<h1>Employees</h1>
	
	<a href="createEmployeeForm.html">Create</a>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>dob</th>
			<th>view in detail</th>
			<th>edit</th>
			<th>delete</th>
		</tr>
		<c:forEach var="employee" items="${employees }">
			<tr>
				<td>${employee.id }</td>
				<td>${ employee.name }</td>
				<td><fmt:formatDate value="${employee.dob}" pattern="yyyy-MM-dd" /></td>
				
				<td><a href="DisplayEmployeeServlet?id=${employee.id }">display</a></td>
				<td><a href="EditEmployeeFormServlet?id=${employee.id }">
						edit</a></td>
				<td><a href="DeleteEmployeeServlet?id=${employee.id }">
						delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>