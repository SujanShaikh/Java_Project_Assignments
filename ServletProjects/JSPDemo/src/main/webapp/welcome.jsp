<html>
<body>
<%
    String name=request.getParameter("uname");
    out.print("Welcome "+name);

    HttpSession session=request.getSession();
    session.setAttribute("user",name);
%>
<a href="second.jsp">second jsp page</a>
</body>
</html>
