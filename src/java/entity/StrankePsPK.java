/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mirko
 */
@Embeddable
public class StrankePsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstr")
    private int idstr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpred")
    private int idpred;

    public StrankePsPK() {
    }

    public StrankePsPK(int idstr, int idpred) {
        this.idstr = idstr;
        this.idpred = idpred;
    }

    public int getIdstr() {
        return idstr;
    }

    public void setIdstr(int idstr) {
        this.idstr = idstr;
    }

    public int getIdpred() {
        return idpred;
    }

    public void setIdpred(int idpred) {
        this.idpred = idpred;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idstr;
        hash += (int) idpred;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StrankePsPK)) {
            return false;
        }
        StrankePsPK other = (StrankePsPK) object;
        if (this.idstr != other.idstr) {
            return false;
        }
        if (this.idpred != other.idpred) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StrankePsPK[ idstr=" + idstr + ", idpred=" + idpred + " ]";
    }
    
}
