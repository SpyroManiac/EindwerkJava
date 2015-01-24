<%-- 
    Document   : ErrorLogin
    Created on : 23-jan-2015, 20:49:40
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
        <h2>Your password or username is wrong</h2>
        <h2>Signup Details</h2>
        <form action="ProcessFolder/Login.jsp" method="post" role="form">
            <br/>Username:<input type="text" name="username">
            <br/>Password:<input type="password" name="password"> 
            <br/><input type="submit" value="Submit"> 
        </form> 
    </body>
</html>
