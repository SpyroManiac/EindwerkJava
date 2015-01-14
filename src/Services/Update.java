/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import javax.persistence.*;

/**
 *
 * @author Jo
 */
public class Update {
    public boolean UpdateProduct(DAL.Product product){
        try{       
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            
            trans.begin();
            em.merge(product);
            trans.commit();
            
            em.close();
            emf.close();
      
            return true;
            
            
        }
        catch(Exception ex)
        {
        return false;
        }
    }
    public boolean UpdateAccount(DAL.Account account){
        try{
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            
            trans.begin();
            em.merge(account);
            trans.commit();
            
            em.close();
            emf.close();
            
            return true;
            
        }
        catch(Exception ex)
        {
        return false;
        }
    }
}
