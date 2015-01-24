<%-- 
    Document   : AddProduct
    Created on : 24-jan-2015, 12:45:24
    Author     : Jo
--%>

<%@page import="DAL.Account"%>
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
            session.setAttribute("prodID", request.getParameter("Aankoop"));
            try {
                int aantal = Integer.parseInt(request.getParameter("Aantal"));
                Long Id = Long.parseLong(request.getParameter("Aankoop"));
                Account a = new Find().findAccountByName((String) session.getAttribute("UserName"));
                int res = new Save().SaveWinkelWagen(a, new Find().findProductById(Id), aantal);
                if (res == 0) {
                    session.setAttribute("error", "An error has occured");
                } else if (res == 1) {
                    session.setAttribute("error", "Product successfully added to shopping cart");
                } else if (res == 2) {
                    session.setAttribute("error", "This product is already in your shopping cart, If you want to change the totals, go to your shopping cart");
                } else {
                    session.setAttribute("error", "Not enough products available for that order, plz mail customer services");
                }
                response.sendRedirect("../ProductPage.jsp");
            } catch (Exception ex) {
                session.setAttribute("error", ex.getMessage());
                response.sendRedirect("../ProductPage.jsp");
            }
        %>
    </body>
</html>
