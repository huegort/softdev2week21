<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Employee (${employee.id })</h1>

	<form action="ProcessEditEmployeeServlet" method="get">
		<div>
			<input type="hidden" name="id" value="${employee.id }"/>
		</div>
		<div>
			Name <input type="text" name="name" value="${employee.name }" />
		</div>
		<div>
			Date <input type="date" name="dob" value="<fmt:formatDate value="${employee.dob}" pattern="yyyy-MM-dd" />" />
		</div>
		<div>
			<input type="submit" value="Edit" />
		</div>

	</form>

</body>
</html>