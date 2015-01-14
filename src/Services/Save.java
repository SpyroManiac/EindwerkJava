/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jo
 */
public class Save {

    /**
     *
     * @param account
     * @return
     */
    public int saveAccount(DAL.Account account)
    {
        try{  
            Find f = new Find();
            long l = f.findAccountByName(account.getNaam()).getId();
            System.out.println(l);
            if(l == 0)
            {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
                EntityManager em = emf.createEntityManager();

                EntityTransaction trans = em.getTransaction();
                
                trans.begin();
                em.persist(account);
                trans.commit();
                em.clear();
                
                em.close();
                emf.close();
                return 0;
            }
            else
            {
                return 2;
            }
        }
        catch(Exception ex){
            return 1;
        }   
    }
    
    public int SaveProduct(DAL.Product product)
    {
        try{
            Find f = new Find();
            long l = f.findProductByName(product.getNaam()).getId();

            if(l == 0)
            {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
                EntityManager em = emf.createEntityManager();

                EntityTransaction trans = em.getTransaction();
                
                trans.begin();
                em.persist(product);
                trans.commit();
                em.clear();
                
                em.close();
                emf.close();
                return 0;
            }
            else
            {
                return 2;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return 1;
        }
    }
}
