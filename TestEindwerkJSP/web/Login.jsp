<%-- 
    Document   : Login
    Created on : 23-jan-2015, 20:02:41
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
        <p><a href="Home.jsp">Home</a></p>
        <h2>Signup Details</h2>
        <form action="ProcessFolder/Login.jsp" method="post" role="form">
            <br/>Username:<input type="text" name="username"/>
            <br/>Password:<input type="password" name="password"/> 
            <br/><input type="submit" value="Submit"/> 
        </form> 
    </body>
</html>
