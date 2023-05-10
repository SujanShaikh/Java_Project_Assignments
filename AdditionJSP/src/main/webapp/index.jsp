<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
 <%
            int number1= Integer.parseInt(request.getParameter("no1"));
            int number2= Integer.parseInt(request.getParameter("no2"));

            int sum=number1+number2;
            out.println("Addition is :: "+sum);
    %>
</body>
</html>
