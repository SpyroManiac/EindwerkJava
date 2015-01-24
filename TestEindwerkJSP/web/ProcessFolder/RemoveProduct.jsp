<%-- 
    Document   : RemoveProduct
    Created on : 24-jan-2015, 14:49:26
    Author     : Jo
--%>

<%@page import="services.Delete"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try {
                Long Id = Long.parseLong(request.getParameter("delete"));
                boolean res = new Delete().DeleteWinkelwagenCanceled(Id);
                if (res = true) {
                    session.setAttribute("error", "Delete done");
                } else {
                    session.setAttribute("error", "A unknown error has occured");
                }
                response.sendRedirect("../WinkelLijst.jsp");
            } catch (Exception ex) {
                session.setAttribute("error", ex.getMessage());
                response.sendRedirect("../WinkelLijst.jsp");
            }
        %>
    </body>
</html>
