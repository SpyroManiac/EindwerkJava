/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAL.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Jo
 */
public class GetList {
    public java.util.List<Account> AccountList() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
        Statement statement = connection.createStatement();

        ResultSet resultset = statement.executeQuery("SELECT * FROM account");
        
        java.util.List<Account> list = new ResultsetConvert().ResultsetToAccountList(resultset);
        return list;
    }
    public java.util.List<Product> ProductList() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
        Statement statement = connection.createStatement();

        ResultSet resultset = statement.executeQuery("SELECT * FROM product");
        java.util.List<Product> list = new ResultsetConvert().ResultsetToProductList(resultset);
        return list;
    }
    public java.util.List<Account> AccountListByName(String naam) throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
        Statement statement = connection.createStatement();

        ResultSet resultset = statement.executeQuery("SELECT * FROM account WHERE naam = '" + naam + "'");
        java.util.List<Account> list = new ResultsetConvert().ResultsetToAccountList(resultset);
        return list;
    }  
    public java.util.List<Product> ProductListByName(String naam) throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
        Statement statement = connection.createStatement();

        ResultSet resultset = statement.executeQuery("SELECT * FROM product WHERE naam = '" + naam + "'");
        java.util.List<Product> list = new ResultsetConvert().ResultsetToProductList(resultset);
        return list;
    }
    public java.util.List<WinkelWagen> WinkelList() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
        Statement statement = connection.createStatement();

        ResultSet resultset = statement.executeQuery("SELECT * FROM winkelwagen");
        java.util.List<WinkelWagen> list = new ResultsetConvert().ResultsetToWinkelwagenList(resultset);
        return list;
    }
    public java.util.List<WinkelWagen> winkelListByIds(long idAccount, long idProduct) throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
        Statement statement = connection.createStatement();

        ResultSet resultset = statement.executeQuery("SELECT * FROM winkelwagen WHERE accountid = '" + idAccount + "' AND productid = '" +idProduct + "'");
        java.util.List<WinkelWagen> list = new ResultsetConvert().ResultsetToWinkelwagenList(resultset);
        return list;
    }
    public ArrayList<Product> WinkelwagenByAccountList(DAL.Account account) throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb", "root", "usbw");
        Statement statement = connection.createStatement();

        ResultSet resultset = statement.executeQuery("SELECT * FROM winkelwagen WHERE accountid = '" + account.getId() + "'");
        java.util.List<WinkelWagen> WinkelList = new ResultsetConvert().ResultsetToWinkelwagenList(resultset);    
        ArrayList<Product> list = new ArrayList<>();
        Find f = new Find();
        
        for(WinkelWagen w : WinkelList)
        {
            System.out.println(w);
            list.add( f.findProductById(w.getProductId()));
            
        }
        System.out.println("Success? " +list.get(0).getNaam());
        return list;
    }
}
