/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAL.*;
import java.sql.*;
import javax.persistence.*;

/**
 *
 * @author Jo
 */
public class Find {
    public DAL.Account findAccountByName(String naam){
        try{
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestEindwerkJSPPU");
//            EntityManager em = emf.createEntityManager();
//            
//            TypedQuery<Account> query = em.createQuery("SELECT d FROM Account d WHERE d.Naam = :naam", Account.class);
//            Account account = query.setParameter("naam", naam).getSingleResult();
//            
////            System.out.println(account.getNaam() + " " + account.getId());
// 
//            em.close();
//            emf.close();
//            return account;
            
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaeindwerkdb","root","usbw");
        Statement statement = connection.createStatement();
        
        ResultSet resultset = statement.executeQuery("SELECT * FROM Account WHERE naam = '" + naam +"'") ; 
        Account a = new ResultsetConvert().ResultsetToAccount(resultset);
        return a;
//        return resultset;
        
        
        }
        
        catch(Exception ex){
            Account nul = new Account();
            nul.setId(Long.parseLong("0"));
            return null;
        }
    }
    public DAL.Product findProductByName(String naam){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestEindwerkJSPPU");
            EntityManager em = emf.createEntityManager();
            
            TypedQuery<Product> query = em.createQuery("SELECT d FROM Product d WHERE d.Naam = :naam", Product.class);
            Product product = query.setParameter("naam", naam).getSingleResult();
            
//            System.out.println(product.getNaam() + " " + product.getId());
            
            em.close();
            emf.close();
            return product;
        }

        catch(Exception ex)
        {
            Product nul = new Product();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }
    public DAL.Account findAccountById(long id){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestEindwerkJSPPU");
            EntityManager em = emf.createEntityManager();
            
            TypedQuery<Account> query = em.createQuery("SELECT d FROM Account d WHERE d.id = :Id", Account.class);
            Account account = query.setParameter("Id", id).getSingleResult();
            
//            System.out.println(account.getNaam() + " " + account.getId());
 
            em.close();
            emf.close();
            return account;
        }
        
        catch(Exception ex){
            Account nul = new Account();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }
    public DAL.Product findProductById(long id){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestEindwerkJSPPU");
            EntityManager em = emf.createEntityManager();
            
            TypedQuery<Product> query = em.createQuery("SELECT d FROM Product d WHERE d.id = :Id", Product.class);
            Product product = query.setParameter("Id", id).getSingleResult();
            
//            System.out.println(product.getNaam() + " " + product.getId());
            
            em.close();
            emf.close();
            return product;
        }

        catch(Exception ex)
        {
            Product nul = new Product();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }
    public DAL.WinkelWagen findWinkelwagenById(long id)
    {
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestEindwerkJSPPU");
            EntityManager em = emf.createEntityManager();
            
            TypedQuery<WinkelWagen> query = em.createQuery("SELECT d FROM WinkelWagen d WHERE d.id = :Id", WinkelWagen.class);
            WinkelWagen winkelWagen = query.setParameter("Id", id).getSingleResult();
            
            em.close();
            emf.close();
            return winkelWagen;
        }

        catch(Exception ex)
        {
            WinkelWagen nul = new WinkelWagen();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }
    public DAL.WinkelWagen findWinkelwagenByMultyId(long idAccount , long idProduct)
    {
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestEindwerkJSPPU");
            EntityManager em = emf.createEntityManager();
            
            TypedQuery<WinkelWagen> query = em.createQuery("SELECT d FROM WinkelWagen d WHERE d.AccountId = :IdAcc AND d.ProductId = :IdProd", WinkelWagen.class);
            WinkelWagen winkelWagen = query.setParameter("IdAcc", idAccount).setParameter("IdProd", idProduct).getSingleResult();
            
            em.close();
            emf.close();
            return winkelWagen;
        }

        catch(Exception ex)
        {
            WinkelWagen nul = new WinkelWagen();
            nul.setId(Long.parseLong("0"));
            return nul;
        }
    }
}
