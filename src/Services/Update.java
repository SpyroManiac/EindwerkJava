/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import java.util.List;
import javax.persistence.*;
import DAL.*;
import java.util.Objects;

/**
 *
 * @author Jo
 */
public class Update {
    public int UpdateProduct(DAL.Product product){
        try{   
            Boolean exists = false;
            List<Product> prodlist = new GetList().ProductListByName(product.getNaam());
            for(Product p: prodlist)
            {
                if(!Objects.equals(p.getId(), product.getId()))
                {
                    exists = true;
                }
            }
            if(exists == false)
            {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            
            trans.begin();
            em.merge(product);
            trans.commit();
            
            em.close();
            emf.close();
      
            return 1;
            }
            else return 2;
            
            
        }
        catch(Exception ex)
        {
        return 0;
        }
    }
    public int UpdateAccount(DAL.Account account){
        try{  
            Boolean exists = false; 
            List<Account> aclist = new GetList().AccountListByName(account.getNaam());
            for(Account a: aclist)
            {
                if(!Objects.equals(a.getId(), account.getId()))
                {
                    exists = true;
                }
            }
            if(exists == false)
            {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            
            trans.begin();
            em.merge(account);
            trans.commit();
            
            em.close();
            emf.close();
            
            return 1;
            }
            else return 2;
            
        }
        catch(Exception ex)
        {
        return 0;
        }
    }
}
