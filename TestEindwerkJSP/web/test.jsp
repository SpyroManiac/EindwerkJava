<%-- 
    Document   : test
    Created on : 21-jan-2015, 18:21:28
    Author     : Jo
--%>

<%@page import="java.util.List"%>
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
            List<Account> accountList = new GetList().AccountList();
            List<Product> productList = new GetList().ProductList();
            List<WinkelWagen> winkelwagenList = new GetList().WinkelList();
        %>
        <h1>Accounts</h1>
        <table>
            <tr>
                <td>id</td>
                <td>naam</td>
                <td>wachtwoord</td>
                <td>admin</td>
            </tr>
            <%
                for (Account a : accountList) {
            %>
            <tr>
                <td><%= a.getId()%></td>
                <td><%= a.getNaam() %></td>
                <td><%= a.getWachtwoord() %> </td>
                <td><%= a.isAdmin() %></td>
            </tr>
            <%}%>
        </table>

        <h1>Products</h1>
        <table>
            <tr>
                <td>id</td>
                <td>naam</td>
                <td>prijs</td>
                <td>totaal</td>
                <td>korting</td>
            </tr>
            <%
                for (Product p : productList) {
            %>
            <tr>
                <td><%= p.getId()%></td>
                <td><%= p.getNaam() %></td>
                <td><%= p.getPrijs() %> </td>
                <td><%= p.getTotaal() %></td>
                <td><%= p.getKorting() %></td>
            </tr>
            <%}%>
        </table>
        
        <h1>Winkelwagen</h1>
        <table>
            <tr>
                <td>id</td>
                <td>account id</td>
                <td>product id</td>
                <td>totaal</td>
            </tr>
            <%
                for (WinkelWagen w : winkelwagenList) {
            %>
            <tr>
                <td><%= w.getId()%></td>
                <td><%= w.getAccountId() %></td>
                <td><%= w.getProductId() %> </td>
                <td><%= w.getTotaal() %></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
