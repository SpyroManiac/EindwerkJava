<%-- 
    Document   : WinkelLijst
    Created on : 24-jan-2015, 13:28:17
    Author     : Jo
--%>

<%@page import="DAL.*"%>
<%@page import="java.util.*"%>
<%@page import="services.*"%>
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
            <p><a href="Home.jsp">Home</a><%if (session.getAttribute("UserName") == null) {
                %> <a href="Login.jsp">Login</a><% } else {%> <a href="ProcessFolder/Logout.jsp">Logout</a><%}%></p>
        </header>
        <h2>Shoppingcart</h2>
        <%
            if (session.getAttribute("error") != null) {
        %>
        <h2><%=session.getAttribute("error")%></h2>
        <%
                session.removeAttribute("error");
            }
            if (session.getAttribute("UserName") == null) {
        %><h1>Please login to use this service</h1><%
        } else {
            Account account = new Find().findAccountByName((String) session.getAttribute("UserName"));
            ArrayList<Product> productLijst = new ArrayList();
            try {
                productLijst = new GetList().WinkelwagenByAccountList(account);
            } catch (Exception ex) {

            }

        %><table>
            <tr>
                <th>Product name</th><th>Total price</th><th colspan="2">Total</th>
            </tr><%                if (!productLijst.isEmpty()) {
                    double totaalPrijs = 0;
                    for (Product p : productLijst) {
                        WinkelWagen winkel = new Find().findWinkelwagenByMultyId(account.getId(), p.getId());
                        double prijs = (p.getPrijs() - (p.getPrijs() / 100 * p.getKorting())) * 100;
                        prijs = Math.round(prijs);
                        prijs = (prijs / 100) * winkel.getTotaal();
                        totaalPrijs += prijs;
            %>
            <tr>

                <td><%= p.getNaam()%></td>
                <td>€<%= prijs%></td>
                <td><form action="ProcessFolder/UpdateWinkelwagen.jsp" method="post"><input type="text" value="<%= winkel.getTotaal()%>" name="ProductTotal"> <input type="hidden" value="<%= winkel.getId()%>" name="update"/>
                        <input type="submit" value="update" name="update"/></form></td>
                <td><form action="ProcessFolder/RemoveProduct.jsp" method="post"><input type="hidden" value="<%= winkel.getId()%>" name="delete"/>
                        <input type="submit" value="delete" name="delete"/></form></td>
            </tr><%
                }
            %></table>
        <p>Total price: €<%= totaalPrijs%></p>

        <%
        } else {
        %><p>No items in your shoppingcart</p><%
                }
            }
        %>
    </body>
</html>
