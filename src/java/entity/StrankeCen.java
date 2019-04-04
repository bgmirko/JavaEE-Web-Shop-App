/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "stranke_cen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StrankeCen.findAll", query = "SELECT s FROM StrankeCen s"),
    @NamedQuery(name = "StrankeCen.findByIdstr", query = "SELECT s FROM StrankeCen s WHERE s.strankeCenPK.idstr = :idstr"),
    @NamedQuery(name = "StrankeCen.findByIdart", query = "SELECT s FROM StrankeCen s WHERE s.strankeCenPK.idart = :idart"),
    @NamedQuery(name = "StrankeCen.findByRabat", query = "SELECT s FROM StrankeCen s WHERE s.rabat = :rabat"),
    @NamedQuery(name = "StrankeCen.findByCena", query = "SELECT s FROM StrankeCen s WHERE s.cena = :cena")})
public class StrankeCen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StrankeCenPK strankeCenPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Rabat")
    private Double rabat;
    @Column(name = "Cena")
    private Double cena;
    @JoinColumn(name = "idstr", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Stranke stranke;

    public StrankeCen() {
    }

    public StrankeCen(StrankeCenPK strankeCenPK) {
        this.strankeCenPK = strankeCenPK;
    }

    public StrankeCen(int idstr, int idart) {
        this.strankeCenPK = new StrankeCenPK(idstr, idart);
    }

    public StrankeCenPK getStrankeCenPK() {
        return strankeCenPK;
    }

    public void setStrankeCenPK(StrankeCenPK strankeCenPK) {
        this.strankeCenPK = strankeCenPK;
    }

    public Double getRabat() {
        return rabat;
    }

    public void setRabat(Double rabat) {
        this.rabat = rabat;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Stranke getStranke() {
        return stranke;
    }

    public void setStranke(Stranke stranke) {
        this.stranke = stranke;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (strankeCenPK != null ? strankeCenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StrankeCen)) {
            return false;
        }
        StrankeCen other = (StrankeCen) object;
        if ((this.strankeCenPK == null && other.strankeCenPK != null) || (this.strankeCenPK != null && !this.strankeCenPK.equals(other.strankeCenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StrankeCen[ strankeCenPK=" + strankeCenPK + " ]";
    }
    
}
