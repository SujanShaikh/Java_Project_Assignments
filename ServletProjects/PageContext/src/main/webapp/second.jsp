<html>
<body>
<%
    // Get "user" attribute from PageContext.PAGE_SCOPE
    String name = (String)pageContext.getAttribute("user", PageContext.SESSION_SCOPE);
    out.print("Hello " + name);
%>
</body>
</html>
