<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>one employee</title>
</head>
<body>
	<h1>Details of the employee</h1>

	<table>
		<tr>
			<td>Id</td>
			<td>${employee.id }</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${employee.name }</td>
		</tr>
	</table>
	<div></div>
	<div>
		<a href="DisplayAllEmployeesServlet">back to view all</a>
	</div>
</body>
</html>