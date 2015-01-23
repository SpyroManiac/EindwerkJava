<%-- 
    Document   : Home
    Created on : 23-jan-2015, 20:11:27
    Author     : Jo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to my shop</h1>
        <%if (session.getAttribute("UserName") == null) {
        %><a href="Login.jsp">Login</a><%
        } else {
        %><p>Hallo <%=session.getAttribute("UserName")%></p>
        <a href="ProcessFolder/Logout.jsp">Logout</a><%}
        %>
    </body>
</html>
