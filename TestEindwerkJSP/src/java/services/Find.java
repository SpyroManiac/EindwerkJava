/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAL.*;
import java.sql.*;

/**
 *
 * @author Jo
 */
public class Find {

    public DAL.Account findAccountByName(String naam) {
        try {
            Account a = new Account();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM Account WHERE naam = '" + naam + "'");
            if (!resultset.isBeforeFirst()) {
                a.setId(Long.parseLong("0"));
            } else {
                a = new ResultsetConvert().ResultsetToAccount(resultset);
            }
            return a;
            
        } catch (SQLException | NumberFormatException ex) {
            Account nul = new Account();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }

    public DAL.Product findProductByName(String naam) {
        try {
            Product p = new Product();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM product WHERE naam = '" + naam + "'");
            if (!resultset.isBeforeFirst()) {
                p.setId(Long.parseLong("0"));
            } else {
                p = new ResultsetConvert().ResultsetToProduct(resultset);
            }
            return p;

        } catch (SQLException | NumberFormatException ex) {
            Product nul = new Product();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }

    public DAL.Account findAccountById(long id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM Account WHERE id = '" + id + "'");
            Account a = new Account();
            if (!resultset.isBeforeFirst()) {
                a.setId(Long.parseLong("0"));
            } else {
                a = new ResultsetConvert().ResultsetToAccount(resultset);
            }
            return a;

        } catch (SQLException | NumberFormatException ex) {
            Account nul = new Account();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }

    public DAL.Product findProductById(long id) {
        try {
            Product p = new Product();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM product WHERE id = '" + id + "'");
            if (!resultset.isBeforeFirst()) {
                p.setId(Long.parseLong("0"));
            } else {
                p = new ResultsetConvert().ResultsetToProduct(resultset);
            }
            return p;
            
        } catch (Exception ex) {
            Product nul = new Product();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }

    public DAL.WinkelWagen findWinkelwagenById(long id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM winkelwagen WHERE id = '" + id + "'");
            WinkelWagen w = new WinkelWagen();
            if (!resultset.isBeforeFirst()) {
                w.setId(Long.parseLong("0"));
            } else {
                w = new ResultsetConvert().ResultsetToWinkelwagen(resultset);
            }
            return w;
            
        } catch (Exception ex) {
            WinkelWagen nul = new WinkelWagen();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }

    public DAL.WinkelWagen findWinkelwagenByMultyId(long idAccount, long idProduct) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM winkelwagen WHERE accountid = '" + idAccount + "' AND productID = '" + idProduct + "'");
            WinkelWagen w = new WinkelWagen();
            if (!resultset.isBeforeFirst()) {
                w.setId(Long.parseLong("0"));
            } else {
                w = new ResultsetConvert().ResultsetToWinkelwagen(resultset);
            }
            return w;
            
        } catch (Exception ex) {
            WinkelWagen nul = new WinkelWagen();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }
}
