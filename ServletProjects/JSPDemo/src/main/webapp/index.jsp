<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Random"%>
        <%@ page info="composed by sujan"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>JSP Tags</h1>
	<%!
	int a=5;
	int b=8;

	  public int sum(int a,int b){return a+b;}
	%>

	<%
	out.println(" Using Scriplet tag :: Sum of "+a+" and "+b+" is :: "+ sum(a,b));
	%>

	 <h2>Using Expression tag :: Sum is :: <%= sum(a,b) %> </h2>

<%@ include file="header.jsp"%>
	 <%
	  Random r=new Random();
	  int n=r.nextInt(10);
	  %>
	  <h3> using random generator ::<%= n %></h3>

</body>
</html>
