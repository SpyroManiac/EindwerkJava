/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAL.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Jo
 */
public class Delete {

    public boolean DeleteProduct(long id) {
        try {
            Find f = new Find();
            Product p = f.findProductById(id);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            PreparedStatement prepaired = null;

            prepaired = connection.prepareStatement("DELETE FROM winkelwagen WHERE productid = ?");
            prepaired.setLong(1, p.getId());
            prepaired.executeUpdate();

            prepaired = connection.prepareStatement("DELETE FROM product WHERE id = ?");
            prepaired.setLong(1, p.getId());
            prepaired.executeUpdate();

            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean DeleteAccount(long id) {
        try {
            Find f = new Find();
            Account a = f.findAccountById(id);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            PreparedStatement prepaired = null;

            prepaired = connection.prepareStatement("DELETE FROM winkelwagen WHERE Accountid = ?");
            prepaired.setLong(1, a.getId());
            prepaired.executeUpdate();

            prepaired = connection.prepareStatement("DELETE FROM account WHERE id = ?");
            prepaired.setLong(1, a.getId());
            prepaired.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    public boolean DeleteWinkelwagenCanceled(long id) {
        try {
 
            Product product = new Find().findProductById(new Find().findWinkelwagenById(id).getProductId());
            product.setTotaal(product.getTotaal() + new Find().findWinkelwagenById(id).getTotaal());
            new Update().UpdateProduct(product);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
            PreparedStatement prepaired = null;

            prepaired = connection.prepareStatement("DELETE FROM winkelwagen WHERE id = ?");
            prepaired.setLong(1, id);
            prepaired.executeUpdate();
          
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
