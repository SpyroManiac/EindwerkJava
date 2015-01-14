/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jo
 */
@Entity
public class WinkelWagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long AccountId;
    private Long ProductId;
    private int Totaal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WinkelWagen)) {
            return false;
        }
        WinkelWagen other = (WinkelWagen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.WinkelWagen[ id=" + id + " ]";
    }

    /**
     * @return the AccountId
     */
    public Long getAccountId() {
        return AccountId;
    }

    /**
     * @param AccountId the AccountId to set
     */
    public void setAccountId(Long AccountId) {
        this.AccountId = AccountId;
    }

    /**
     * @return the ProductId
     */
    public Long getProductId() {
        return ProductId;
    }

    /**
     * @param ProductId the ProductId to set
     */
    public void setProductId(Long ProductId) {
        this.ProductId = ProductId;
    }

    /**
     * @return the Totaal
     */
    public int getTotaal() {
        return Totaal;
    }

    /**
     * @param Totaal the Totaal to set
     */
    public void setTotaal(int Totaal) {
        this.Totaal = Totaal;
    }
    
}
