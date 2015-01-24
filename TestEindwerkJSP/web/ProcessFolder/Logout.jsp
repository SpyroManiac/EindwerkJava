<%-- 
    Document   : Logout
    Created on : 23-jan-2015, 21:14:42
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
        <%
            session.removeAttribute("UserName"); 
            session.removeAttribute("error");
            session.invalidate();
            response.sendRedirect("../Home.jsp");
            %>
    </body>
</html>
