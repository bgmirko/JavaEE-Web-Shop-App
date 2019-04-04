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
public class ArtikliPsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idart")
    private int idart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmag")
    private int idmag;

    public ArtikliPsPK() {
    }

    public ArtikliPsPK(int idart, int idmag) {
        this.idart = idart;
        this.idmag = idmag;
    }

    public int getIdart() {
        return idart;
    }

    public void setIdart(int idart) {
        this.idart = idart;
    }

    public int getIdmag() {
        return idmag;
    }

    public void setIdmag(int idmag) {
        this.idmag = idmag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idart;
        hash += (int) idmag;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtikliPsPK)) {
            return false;
        }
        ArtikliPsPK other = (ArtikliPsPK) object;
        if (this.idart != other.idart) {
            return false;
        }
        if (this.idmag != other.idmag) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ArtikliPsPK[ idart=" + idart + ", idmag=" + idmag + " ]";
    }
    
}
