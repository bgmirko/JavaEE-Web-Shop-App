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
public class StrankeCenPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstr")
    private int idstr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idart")
    private int idart;

    public StrankeCenPK() {
    }

    public StrankeCenPK(int idstr, int idart) {
        this.idstr = idstr;
        this.idart = idart;
    }

    public int getIdstr() {
        return idstr;
    }

    public void setIdstr(int idstr) {
        this.idstr = idstr;
    }

    public int getIdart() {
        return idart;
    }

    public void setIdart(int idart) {
        this.idart = idart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idstr;
        hash += (int) idart;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StrankeCenPK)) {
            return false;
        }
        StrankeCenPK other = (StrankeCenPK) object;
        if (this.idstr != other.idstr) {
            return false;
        }
        if (this.idart != other.idart) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StrankeCenPK[ idstr=" + idstr + ", idart=" + idart + " ]";
    }
    
}
