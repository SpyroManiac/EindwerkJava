/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindwerkjava;

import DAL.*;
import Services.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jo
 */
public class test {
    public static void main(String[] args) {
        WinkelWagen w = new WinkelWagen();
        w.setAccountId(Long.parseLong("1153"));
        w.setProductId(Long.parseLong("1901"));
        w.setTotaal(2);
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
                EntityManager em = emf.createEntityManager();

                EntityTransaction trans = em.getTransaction();
                
                trans.begin();
                em.persist(w);
                trans.commit();
                em.clear();
                
                em.close();
                emf.close();
       

    }
}
