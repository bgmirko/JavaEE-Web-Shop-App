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
public class FakstavkeProPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfak")
    private int idfak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idart")
    private int idart;

    public FakstavkeProPK() {
    }

    public FakstavkeProPK(int idfak, int idart) {
        this.idfak = idfak;
        this.idart = idart;
    }

    public int getIdfak() {
        return idfak;
    }

    public void setIdfak(int idfak) {
        this.idfak = idfak;
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
        hash += (int) idfak;
        hash += (int) idart;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FakstavkeProPK)) {
            return false;
        }
        FakstavkeProPK other = (FakstavkeProPK) object;
        if (this.idfak != other.idfak) {
            return false;
        }
        if (this.idart != other.idart) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FakstavkeProPK[ idfak=" + idfak + ", idart=" + idart + " ]";
    }
    
}
