/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.*;
import java.util.List;
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
                long id = 0;
                List<Account> resultlist = new GetList().AccountList();
                if (!resultlist.isEmpty()) {
                    for (Account a : resultlist) {
                        if (id < a.getId()) {
                            id = a.getId();
                        }
                    }
                    id = id + 1;
                } else {
                    id = 1;
                }
                account.setId(id);
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
                long id = 0;
                List<Product> resultlist = new GetList().ProductList();
                if (!resultlist.isEmpty()) {
                    for (Product a : resultlist) {
                        if (id < a.getId()) {
                            id = a.getId();
                        }
                    }
                    id = id + 1;
                } else {
                    id = 1;
                }
                product.setId(id);
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
    
    public int SaveWinkelWagen(DAL.Account account , DAL.Product product, int totaal)
    {
        try
        {
            Find f = new Find();
            long result = f.findWinkelwagenByMultyId(account.getId(), product.getId()).getId();
            if(result== 0 && totaal <= product.getTotaal() )
            {
                long id = 0;
                List<WinkelWagen> resultlist = new GetList().WinkelList();
                if (!resultlist.isEmpty()) {
                    for (WinkelWagen a : resultlist) {
                        if (id < a.getId()) {
                            id = a.getId();
                        }
                    }
                    id = id + 1;
                } else {
                    id = 1;
                }
                
                WinkelWagen w = new WinkelWagen();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
                EntityManager em = emf.createEntityManager();

                EntityTransaction trans = em.getTransaction();
                w.setAccountId(account.getId());
                w.setProductId(product.getId());
                w.setTotaal(totaal);
                w.setId(id);

                product.setTotaal(product.getTotaal() - totaal);
                new Update().UpdateProduct(product);
                trans.begin();
                em.persist(w);
                trans.commit();
                em.close();
                emf.close();
       
            }
            else if(result== 0 && totaal > product.getTotaal()) return 3;
            else return 2;
                
        return 0;
        }
        catch(Exception ex)
        {
            return 1;
        }
        
    }
}
