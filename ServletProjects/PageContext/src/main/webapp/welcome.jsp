<html>
<body>
<%
    String name = session.getParameter("uname");
    out.print("Welcome " + name);

    pageContext.setAttribute("user", name, PageContext.REQUEST_SCOPE);
%>
<a href="second.jsp">Go to second JSP page</a>
</body>
</html>
