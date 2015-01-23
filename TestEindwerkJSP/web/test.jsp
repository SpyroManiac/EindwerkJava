<%-- 
    Document   : test
    Created on : 21-jan-2015, 18:21:28
    Author     : Jo
--%>

<%@page import="java.util.List"%>
<%@page import="DAL.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="services.*"%>
<%@page import="Controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            LoginController l = new LoginController();
            out.println(l.Login("jo", "jo"));
        %>
    </body>
</html>
