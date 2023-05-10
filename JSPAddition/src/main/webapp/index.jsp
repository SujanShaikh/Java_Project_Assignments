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


<div align='center'>
	<h2> Addition of Number</h2>
	<form action="" method="">
	Enter 1 number:
	<input type="text" name="no1">
	<br><br>
	Enter 2 number:
    <input type="text" name="no2">
    <br><br>
    <input type="submit" name="submit" value="Add Numbers">

	</form>
	</div>
<%
        int number1= Integer.parseInt(request.getParameter("no1"));
        int number2= Integer.parseInt(request.getParameter("no2"));

        int sum=number1+number2;
        out.println("Addition is :: "+sum);
%>

</body>
</html>
