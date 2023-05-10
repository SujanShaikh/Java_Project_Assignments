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
   <jsp:useBean id="student" class="com.Student" scope="application"/>
   <jsp:setProperty property="*" name="student"/>

   <h1>Student details are</h1><br>
   ID :: <jsp:getProperty property="id" name="student"/><br>
   First name :: <jsp:getProperty property="fname" name="student"/><br>
   Last name :: <jsp:getProperty property="lname" name="student"/><br>
</body>
</html>