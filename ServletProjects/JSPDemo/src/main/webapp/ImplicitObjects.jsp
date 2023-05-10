<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page info=" sujan"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>JSP Tags</h1>
	<%-- Using the out implicit object to print the current date --%>
	Out :: Todays Date is ::
    	<%
    		out.println(new Date().toString());
    	%>
       <%
       String name=request.getParameter("uname");
       out.println("<h3>Welcome "+ name + "</h3>");
       %>
       <%
       String driver=config.getInitParameter("dname");
          out.println("<h3> Config :: Driver name:: "+ driver + "</h3>");
       %>
       <%
              String driver1=application.getInitParameter("dname1");
              out.println("<h3> Context :: Driver name:: "+ driver1 + "</h3>");
              %>
              <%

              %>


</body>
</html>
