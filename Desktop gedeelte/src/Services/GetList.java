/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jo
 */
public class GetList {
    public java.util.List<Account> AccountList()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
        EntityManager em = emf.createEntityManager();
            
        TypedQuery<Account> query = em.createQuery("SELECT d FROM Account d", Account.class);
        java.util.List<Account> list = query.getResultList();
        return list;
    }
    public java.util.List<Product> ProductList()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
        EntityManager em = emf.createEntityManager();
            
        TypedQuery<Product> query = em.createQuery("SELECT d FROM Product d", Product.class);
        java.util.List<Product> list = query.getResultList();
        return list;
    }
    public java.util.List<Account> AccountListByName(String naam)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
        EntityManager em = emf.createEntityManager();
            
        TypedQuery<Account> query = em.createQuery("SELECT d FROM Account d WHERE d.Naam = :Naam", Account.class).setParameter("Naam", naam );
        java.util.List<Account> list = query.getResultList();
        return list;
    }  
    public java.util.List<Product> ProductListByName(String naam)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
        EntityManager em = emf.createEntityManager();
            
        TypedQuery<Product> query = em.createQuery("SELECT d FROM Product d WHERE d.Naam = :Naam", Product.class).setParameter("Naam", naam);
        java.util.List<Product> list = query.getResultList();
        return list;
    }
    public java.util.List<WinkelWagen> WinkelList()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
        EntityManager em = emf.createEntityManager();
            
        TypedQuery<WinkelWagen> query = em.createQuery("SELECT d FROM WinkelWagen d", WinkelWagen.class);
        java.util.List<WinkelWagen> list = query.getResultList();
        return list;
    }
    
    public java.util.List<WinkelWagen> winkelListByIds(long idAccount, long idProduct)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
        EntityManager em = emf.createEntityManager();
            
        TypedQuery<WinkelWagen> query = em.createQuery("SELECT d FROM WinkelWagen d WHERE d.AccountId = :aId and d.ProductId = :pId", WinkelWagen.class).setParameter("aId", idAccount).setParameter("pId", idProduct);
        java.util.List<WinkelWagen> list = query.getResultList();
        return list;
    }
    
    public ArrayList<Product> WinkelwagenByAccountList(DAL.Account account)
    {
        System.out.println(account.getNaam() +" " + account.getId());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
        EntityManager em = emf.createEntityManager();
            
        Query query = em.createQuery("SELECT d.ProductId FROM WinkelWagen d WHERE d.AccountId = :Id", WinkelWagen.class);
        List<Long> WList = query.setParameter("Id", account.getId()).getResultList();
        System.out.println(WList.get(0));
        
        ArrayList<Product> list = new ArrayList<>();
        Find f = new Find();
        
        for(Long w : WList)
        {
            System.out.println(w);
            list.add( f.findProductById(w));
            
        }
        System.out.println("Success? " +list.get(0).getNaam());
        return list;
    }
}
