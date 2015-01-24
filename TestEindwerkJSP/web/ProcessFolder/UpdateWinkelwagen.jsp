<%-- 
    Document   : UpdateWinkelwagen
    Created on : 24-jan-2015, 14:29:11
    Author     : Jo
--%>

<%@page import="services.*"%>
<%@page import="DAL.WinkelWagen"%>
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
                Long Id = Long.parseLong(request.getParameter("update"));
                double prodTotaal = Double.parseDouble(request.getParameter("ProductTotal"));
                int ProdRounded = Integer.parseInt(Long.toString(Math.round(prodTotaal)));
                WinkelWagen w = new Find().findWinkelwagenById(Id);
                w.setTotaal(ProdRounded);
                int res = new Update().UpdateWinkelwagen(w);
                if(res == 0)session.setAttribute("error", "An error has occured");
                else if( res == 1) session.setAttribute("error", "Update successfull");
                else session.setAttribute("error", "Update successfull");
                
                response.sendRedirect("../WinkelLijst.jsp");
            } catch (Exception ex) {
                session.setAttribute("error", ex.getMessage());

                response.sendRedirect("../WinkelLijst.jsp");
            }
        %>
    </body>
</html>
