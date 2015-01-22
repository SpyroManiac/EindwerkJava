<%-- 
    Document   : test
    Created on : 21-jan-2015, 18:21:28
    Author     : Jo
--%>

<%@page import="DAL.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="services.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Account a = new Find().findAccountByName("jo");
            %>
            
            
            <TABLE BORDER="1">
            <TR>
                <TH>Id</TH>
                <TH>Admin</TH>
                <TH>Naam</TH>
                <TH>Password</TH>
            </TR>
            
                <TR>
                    <TD> 
                        <%=a.getId()%>  
                    </TD>
                    <TD> 
                        <%=a.isAdmin()%>  
                    </TD>
                    <TD> 
                        <%= a.getNaam() %>  
                    </TD>
                    <TD> 
                        <%= a.getWachtwoord() %>  
                    </TD>
                </TR>

        </TABLE>
    </body>
</html>
