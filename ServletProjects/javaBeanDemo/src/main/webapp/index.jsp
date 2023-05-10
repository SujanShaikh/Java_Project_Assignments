<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/CustomTag.tld" prefix="ani" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Java Bean</h1>
	<form method="get"  action="welcome.jsp">
	Enter id: <input type="text" name="id">
	Enter first Name: <input type="text" name="fname">
	Enter last Name: <input type="text" name="lname">
<input type="submit" name="submit">
<hr>
Hello......
<ani:MyMsg/>

	</form>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
