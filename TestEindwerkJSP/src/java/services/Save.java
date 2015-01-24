/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAL.*;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Jo
 */
public class Save {

    public int saveAccount(DAL.Account account) {
        try {
            Find f = new Find();
            long l = f.findAccountByName(account.getNaam()).getId();
            if (l == 0) {

                long id = 0;
                List<Account> resultlist = new GetList().AccountList();
                if (!resultlist.isEmpty()) {
                    for (Account a : resultlist) {
                        if (id < a.getId()) {
                            id = a.getId();
                        }
                    }
                    id = id + 1;
                } else {
                    id = 1;
                }

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
                PreparedStatement prepaired = connection.prepareStatement("INSERT INTO account (naam , wachtwoord, admin,id) VALUES (?,?,?,?)");

                prepaired.setString(1, account.getNaam());
                prepaired.setString(2, account.getWachtwoord());
                prepaired.setBoolean(3, account.isAdmin());
                prepaired.setLong(4, id);
                prepaired.execute();
                return 1;
            } else {
                return 2;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public int SaveProduct(DAL.Product product) {
        try {
            Find f = new Find();
            long l = f.findProductByName(product.getNaam()).getId();
            if (l == 0) {

                long id = 0;
                List<Product> resultlist = new GetList().ProductList();
                if (!resultlist.isEmpty()) {
                    for (Product a : resultlist) {
                        if (id < a.getId()) {
                            id = a.getId();
                        }
                    }
                    id = id + 1;
                } else {
                    id = 1;
                }

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
                PreparedStatement prepaired = connection.prepareStatement("INSERT INTO product (naam , korting, prijs,totaal,id) VALUES (?,?,?,?,?)");

                prepaired.setString(1, product.getNaam());
                prepaired.setDouble(2, product.getKorting());
                prepaired.setDouble(3, product.getPrijs());
                prepaired.setInt(4, product.getTotaal());
                prepaired.setLong(5, id);

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

    public int SaveWinkelWagen(DAL.Account account, DAL.Product product, int totaal) {
        try {
            Find f = new Find();
            long result = f.findWinkelwagenByMultyId(account.getId(), product.getId()).getId();
            if (result == 0 && totaal <= product.getTotaal()) {

                long id = 0;
                List<WinkelWagen> resultlist = new GetList().WinkelList();
                if (!resultlist.isEmpty()) {
                    for (WinkelWagen a : resultlist) {
                        if (id < a.getId()) {
                            id = a.getId();
                        }
                    }
                    id += 1;
                } else {
                    id = 1;
                }

                WinkelWagen w = new WinkelWagen();

                w.setAccountId(account.getId());
                w.setProductId(product.getId());
                w.setTotaal(totaal);

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
                PreparedStatement prepaired = connection.prepareStatement("INSERT INTO winkelwagen (accountid , productid, totaal,id) VALUES (?,?,?,?)");

                prepaired.setLong(1, w.getAccountId());
                prepaired.setLong(2, w.getProductId());
                prepaired.setInt(3, w.getTotaal());
                prepaired.setLong(4, id);
                prepaired.executeUpdate();

                product.setTotaal(product.getTotaal() - totaal);
                new Update().UpdateProduct(product);
                return 1;
            } else if (result == 0 && totaal > product.getTotaal()) {
                return 3;
            } else {
                return 2;
            }

        } catch (Exception ex) {
            return 0;
        }

    }
}
