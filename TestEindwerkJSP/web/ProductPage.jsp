<%-- 
    Document   : ProductPage
    Created on : 24-jan-2015, 12:45:33
    Author     : Jo
--%>

<%@page import="DAL.Product"%>
<%@page import="services.Find"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><a href="Home.jsp">Home</a><%if (session.getAttribute("UserName") == null) {
        %><a href="Login.jsp">Login</a><% } else {%> <a href="ProcessFolder/Logout.jsp">Logout</a> <a href="WinkelLijst.jsp">Winkellist</a></p>
        

        <%}
            if (session.getAttribute("error") != null) {%><p><%= session.getAttribute("error")%></p><% session.removeAttribute("error");}
            Long id;
            if (session.getAttribute("prodID") == null) {
                id = Long.parseLong((String) request.getParameter("submit_id"));
            } else {
                id = Long.parseLong((String) session.getAttribute("prodID"));
                session.removeAttribute("prodID");
            }
            Product p = new Find().findProductById(id);
        %>
        <h2>Product Name: <%=p.getNaam()%></h2>
        <p>price €<%= p.getPrijs()%></p>
        <% if (p.getKorting() != 0) {
                double prijs = (p.getPrijs() - (p.getPrijs() / 100 * p.getKorting())) * 100;
                prijs = Math.round(prijs);
                prijs = prijs / 100;%>
        <p>Korting: <%= p.getKorting()%></p>
        <p>New price: <%= prijs%></p><%
            }%>
        <p>Total left: <%= p.getTotaal()%></p>
        <% if (session.getAttribute("UserName") != null) {%>
        <form action="ProcessFolder/AddProduct.jsp" method="post">
            <p>Aantal: <input type="text" name="Aantal"/>
                <input type="hidden" value="<%= p.getId()%>" name="Aankoop"/>
                <input type="submit" value="Buy" name="Aankoop"/></p></form>
        <%} else%><p>Log in to buy products</p>
    </form>
</body>
</html>
