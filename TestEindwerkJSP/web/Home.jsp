<%-- 
    Document   : Home
    Created on : 23-jan-2015, 20:11:27
    Author     : Jo
--%>

<%@page import="services.GetList"%>
<%@page import="DAL.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to my shop</h1>
        
        <%
            if (session.getAttribute("UserName") == null) {
        %><a href="Login.jsp">Login</a><% } else {%>  <p>Hallo <%=session.getAttribute("UserName")%> <a href="ProcessFolder/Logout.jsp">Logout</a> <a href="WinkelLijst.jsp">Winkellist</a></p>

        <%}
            List<Product> l = new GetList().ProductList();%>

        <table >
            <tr>
                <td>Product</td><td>Price</td><td>Check product</td>
            </tr>
            <% double prijs;
                for (Product p : l) {
                    prijs = (p.getPrijs() - (p.getPrijs() / 100 * p.getKorting())) * 100;
                    prijs = Math.round(prijs);
                    prijs = prijs / 100;%>
            <tr>
                <td><%=p.getNaam()%></td><td>€<%=prijs%></td>
                <td><form action="ProductPage.jsp" method="get">
                        <input type="hidden" name="submit_id" value="<%=p.getId()%>" />
                        <input id="<%=p.getId()%>" name="submit_id" value="CheckProduct" type="submit"/>
                    </form>
                </td>
            </tr>
            <% }%>
        </table>

    </body>
</html>
