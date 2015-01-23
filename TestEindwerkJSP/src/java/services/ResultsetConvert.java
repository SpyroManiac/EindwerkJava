/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAL.*;
import java.util.*;
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
                a.setAdmin(result.getBoolean(4));
                a.setNaam(result.getString(2));
                a.setWachtwoord(result.getString(3));           
            }
            return a;
        } catch (Exception ex) {
            Account a = new Account();
            a.setNaam("Error");
            return a;
        }
    }
    
    public DAL.Product ResultsetToProduct(ResultSet result) throws SQLException {
        try {
            Product p = new Product();
            while(result.next()){       
                p.setId(result.getLong(1));
                p.setKorting(result.getDouble(2));
                p.setNaam(result.getString(3));
                p.setPrijs(result.getDouble(4));
                p.setTotaal(result.getInt(5));
                
            }
            return p;
        } catch (Exception ex) {
            Product p = new Product();
            p.setNaam("Error");
            return p;
        }
    }
    
    public DAL.WinkelWagen ResultsetToWinkelwagen(ResultSet result) throws SQLException
    {
        try {
            WinkelWagen w = new WinkelWagen();
            while(result.next()){       
                w.setId(result.getLong(1));
                w.setAccountId(result.getLong(2));
                w.setProductId(result.getLong(3));
                w.setTotaal(result.getInt(4));
            }
            return w;
        } catch (Exception ex) {
            WinkelWagen w = new WinkelWagen();
            w.setId(Long.parseLong("0"));
            return w;
        }
    }
    
    public java.util.ArrayList<DAL.Account> ResultsetToAccountList(ResultSet result) throws SQLException {
        try {
            ArrayList<Account> acList = new ArrayList<>();
            
            while(result.next()){ 
                Account a = new Account();              
                a.setId(result.getLong(1));
                a.setAdmin(result.getBoolean(2));
                a.setNaam(result.getString(3));
                a.setWachtwoord(result.getString(4)); 
                acList.add(a);
            }
            return acList;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public java.util.ArrayList<DAL.Product> ResultsetToProductList(ResultSet result) throws SQLException {
        try {
            ArrayList<Product> prList = new ArrayList<>();
            while(result.next()){       
                Product p = new Product();
                p.setId(result.getLong(1));
                p.setKorting(result.getDouble(2));
                p.setNaam(result.getString(3));
                p.setPrijs(result.getDouble(4));
                p.setTotaal(result.getInt(5));
                prList.add(p);
            }
            return prList;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public java.util.ArrayList<DAL.WinkelWagen> ResultsetToWinkelwagenList(ResultSet result) throws SQLException
    {
        try {
            ArrayList<WinkelWagen> wkList = new ArrayList<>();
           
            while(result.next()){      
                WinkelWagen w = new WinkelWagen();
                w.setId(result.getLong(1));
                w.setAccountId(result.getLong(2));
                w.setProductId(result.getLong(3));
                w.setTotaal(result.getInt(4));
                wkList.add(w);
            }
            return wkList;
        } catch (Exception ex) {
            return null;
        }
    }
}
