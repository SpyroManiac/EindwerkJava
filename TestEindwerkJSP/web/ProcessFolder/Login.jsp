<%-- 
    Document   : testclasspage
    Created on : 22-jan-2015, 14:47:19
    Author     : Jo
--%>

<%@page import="Controller.LoginController"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="services.*"%>
<%@page import="DAL.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            LoginController c = new LoginController();
            boolean s = c.Login(username, password);
            if(s == true){
                session.setAttribute("UserName", username);
                response.sendRedirect("../Home.jsp");
            }
            
            else response.sendRedirect("../ErrorLogin.jsp");
        %>
        
    </body>
</html>
