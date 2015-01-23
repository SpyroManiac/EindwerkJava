/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAL.*;
import java.sql.*;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jo
 */
public class Update {

    public int UpdateProduct(DAL.Product product) {
        try {
            Boolean exists = false;
            List<Product> prodlist = new GetList().ProductListByName(product.getNaam());
            for (Product p : prodlist) {
                if (!Objects.equals(p.getId(), product.getId())) {
                    exists = true;
                }
            }
            if (exists == false) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
                PreparedStatement prepaired = null;
                prepaired = connection.prepareStatement("UPDATE product SET korting = ? , naam = ? , prijs = ? , totaal = ? WHERE id = ?");

                prepaired.setDouble(1, product.getKorting());
                prepaired.setString(2, product.getNaam());
                prepaired.setDouble(3, product.getPrijs());
                prepaired.setInt(4, product.getTotaal());
                prepaired.setLong(5, product.getId());

                prepaired.executeUpdate();

//                statement.executeUpdate("Update account SET korting = '" + product.getKorting() + "'"
//                        + ", naam = '" + product.getNaam() + "'"
//                        + ", prijs = '" + product.getPrijs() + "'"
//                        + ", totaal = '" + product.getTotaal() + "'"
//                        + "WHERE id= '" + product.getId() + "'");
                return 1;
            } else {
                return 2;
            }

        } catch (Exception ex) {
            return 0;
        }
    }

    public int UpdateAccount(DAL.Account account) {
        try {
            Boolean exists = false;
            List<Account> aclist = new GetList().AccountListByName(account.getNaam());
            for (Account a : aclist) {
                if (!Objects.equals(a.getId(), account.getId())) {
                    exists = true;
                }
            }
            if (exists == false) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
                PreparedStatement prepaired = null;
                prepaired = connection.prepareStatement("UPDATE account SET naam = ? , wachtwoord = ? , admin = ? WHERE id = ?");

                prepaired.setString(1, account.getNaam());
                prepaired.setString(2, account.getWachtwoord());
                prepaired.setBoolean(3, account.isAdmin());
                prepaired.setLong(4, account.getId());

                prepaired.executeUpdate();
                return 1;
            } else {
                return 2;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public int UpdateWinkelwagen(DAL.WinkelWagen winkel) {
        try {
            Boolean exists = false;
            int totaal = 0;
            List<WinkelWagen> wclist = new GetList().winkelListByIds(winkel.getAccountId(), winkel.getProductId());
            for (WinkelWagen w : wclist) {
                if (!Objects.equals(w.getId(), winkel.getId())) {
                    exists = true;
                } else {
                    totaal = w.getTotaal();
                }
            }
            System.out.println(exists);
            if (exists == false) {
                if (winkel.getTotaal() <= (new Find().findProductById(winkel.getProductId()).getTotaal() + totaal)) {
                    Product prodResult = new Find().findProductById(winkel.getProductId());
                    
                    prodResult.setTotaal(prodResult.getTotaal() + totaal - winkel.getTotaal());
                    UpdateProduct(prodResult);

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
                    PreparedStatement prepaired = null;
                    
                    prepaired = connection.prepareStatement("UPDATE winkelwagen SET accountid = ? , productid = ? , totaal = ? WHERE id = ?");

                    prepaired.setLong(1, winkel.getAccountId());
                    prepaired.setLong(2, winkel.getProductId());
                    prepaired.setInt(3, winkel.getTotaal());
                    prepaired.setLong(4, winkel.getId());

                    prepaired.executeUpdate();
                    
                    return 1;
                } else if (winkel.getTotaal() > (new Find().findProductById(winkel.getProductId()).getTotaal() + totaal)) {
                    return 3;
                }
                else {
                    return 4; 
                }
            } else {
                return 2;
            }
        } catch (Exception ex) {
            return 0;
        }
        
    }
}
