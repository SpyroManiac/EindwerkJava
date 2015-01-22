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

    public int UpdateProduct(DAL.Product product) {
        try {
            Boolean exists = false;
            List<Product> prodlist = new GetList().ProductListByName(product.getNaam());
            for (Product p : prodlist) {
                if (!Objects.equals(p.getId(), product.getId())) {
                    exists = true;
                }
            }
            if (exists == false) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
                EntityManager em = emf.createEntityManager();
                EntityTransaction trans = em.getTransaction();

                trans.begin();
                em.merge(product);
                trans.commit();

                em.close();
                emf.close();

                return 1;
            } else {
                return 2;
            }

        } catch (Exception ex) {
            return 0;
        }
    }

    public int UpdateAccount(DAL.Account account) {
        try {
            Boolean exists = false;
            List<Account> aclist = new GetList().AccountListByName(account.getNaam());
            for (Account a : aclist) {
                if (!Objects.equals(a.getId(), account.getId())) {
                    exists = true;
                }
            }
            if (exists == false) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
                EntityManager em = emf.createEntityManager();
                EntityTransaction trans = em.getTransaction();

                trans.begin();
                em.merge(account);
                trans.commit();

                em.close();
                emf.close();

                return 1;
            } else {
                return 2;
            }

        } catch (Exception ex) {
            return 0;
        }
    }

    public int UpdateWinkelwagen(DAL.WinkelWagen winkel) {
        try {
            Boolean exists = false;
            int totaal = 0;
            List<WinkelWagen> wclist = new GetList().winkelListByIds(winkel.getAccountId(), winkel.getProductId());
            for (WinkelWagen w : wclist) {
                if (!Objects.equals(w.getId(), winkel.getId())) {
                    exists = true;
                } else {
                    totaal = w.getTotaal();
                }

            }
            System.out.println(exists);
            if (exists == false) {
                if (winkel.getTotaal() <= (new Find().findProductById(winkel.getProductId()).getTotaal() + totaal)) {
                    Product prodResult = new Find().findProductById(winkel.getProductId());
                    prodResult.setTotaal(prodResult.getTotaal() + totaal - winkel.getTotaal());
                    UpdateProduct(prodResult);

                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EindwerkJavaPU");
                    EntityManager em = emf.createEntityManager();
                    EntityTransaction trans = em.getTransaction();

                    trans.begin();
                    em.merge(winkel);
                    trans.commit();

                    em.close();
                    emf.close();
                    return 1;
                } else if (winkel.getTotaal() > (new Find().findProductById(winkel.getProductId()).getTotaal() + totaal)) {
                    return 3;
                }
            } else {
                return 2;
            }
        } 
        catch (Exception ex) {
            return 0;
        }
        return 0;
    }
}
