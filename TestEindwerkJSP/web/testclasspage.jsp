<%-- 
    Document   : testclasspage
    Created on : 22-jan-2015, 14:47:19
    Author     : Jo
--%>

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
           new Save().SaveWinkelWagen(new Find().findAccountById(1), new Find().findProductById(1), 20);
           new Save().SaveWinkelWagen(new Find().findAccountById(2), new Find().findProductById(1), 50);
           new Save().SaveWinkelWagen(new Find().findAccountById(2), new Find().findProductById(2), 1);
        %>
    </body>
</html>
