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
        <link type="text/css" rel="stylesheet" href="CSS/MainCss.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>Java shop</h1>
            <p><a href="Home.jsp">Home</a></p>
        </header>
        <h2>Your password or username is wrong</h2>
        <h2>Signup Details</h2>
        <div class="Login">
            <form action="ProcessFolder/Login.jsp" method="post" role="form">
                <table>
                    <tr><td>Username:</td><td><input type="text" name="username"></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="password"> </td></tr>
                    <tr><td colspan="2" class="submit"><input type="submit" value="Submit"> </td></tr>
                </table>
            </form> 
        </div>
    </body>
</html>
