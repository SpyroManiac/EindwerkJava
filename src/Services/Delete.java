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
public class Delete {
    public boolean DeleteProduct(int id){
        try{
            Find f = new Find();
            Product p = f.findProductById(id);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
            EntityManager em = emf.createEntityManager();

            EntityTransaction trans = em.getTransaction();
            trans.begin();
            
            TypedQuery<Product> query = em.createQuery("DELETE FROM Product p WHERE p.id = :Id",Product.class);
            query.setParameter("Id", p.getId()).executeUpdate();
            
            trans.commit();
            em.close();
            emf.close();
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        return false;
        }
    }
    public boolean DeleteAccount(int id){
        try{
            Find f = new Find();
            Account a = f.findAccountById(id);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            
            TypedQuery<Account> query = em.createQuery("DELETE FROM Account p WHERE p.id = :Id",Account.class);
            query.setParameter("Id", a.getId()).executeUpdate();
            
            trans.commit();
            em.close();
            emf.close();
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        return false;
        }
    }
}
