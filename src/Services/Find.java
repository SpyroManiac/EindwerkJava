/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.*;
import javax.persistence.*;

/**
 *
 * @author Jo
 */
public class Find {
    public DAL.Account findAccountByName(String naam){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
            EntityManager em = emf.createEntityManager();
            
            TypedQuery<Account> query = em.createQuery("SELECT d FROM Account d WHERE d.Naam = :naam", Account.class);
            Account account = query.setParameter("naam", naam).getSingleResult();
            
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
    public DAL.Product findProductByName(String naam){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
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
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
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
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
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
}
