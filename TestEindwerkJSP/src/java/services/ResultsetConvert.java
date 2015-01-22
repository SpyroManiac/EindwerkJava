/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAL.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jo
 */
public class ResultsetConvert {

    public DAL.Account ResultsetToAccount(ResultSet result) throws SQLException {
        try {
            Account a = new Account();
            while(result.next()){
                
                a.setId(result.getLong(1));
                a.setAdmin(result.getBoolean(2));
                a.setNaam(result.getString(3));
                a.setWachtwoord(result.getString(4));
            
            }
            return a;
        } catch (Exception ex) {
            Account a = new Account();
            a.setNaam("Error");
            return a;
        }
    }
}
