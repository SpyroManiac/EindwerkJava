/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.*;

/**
 *
 * @author Jo
 */
public class testclass {
    public ResultSet testclass() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb","root","usbw");

        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM Account") ; 
        return resultset;
    }
}
