/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "stranke_ps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StrankePs.findAll", query = "SELECT s FROM StrankePs s"),
    @NamedQuery(name = "StrankePs.findByIdstr", query = "SELECT s FROM StrankePs s WHERE s.strankePsPK.idstr = :idstr"),
    @NamedQuery(name = "StrankePs.findByIdpred", query = "SELECT s FROM StrankePs s WHERE s.strankePsPK.idpred = :idpred"),
    @NamedQuery(name = "StrankePs.findByDatum", query = "SELECT s FROM StrankePs s WHERE s.datum = :datum"),
    @NamedQuery(name = "StrankePs.findByPstanje", query = "SELECT s FROM StrankePs s WHERE s.pstanje = :pstanje"),
    @NamedQuery(name = "StrankePs.findByPotrazivanje", query = "SELECT s FROM StrankePs s WHERE s.potrazivanje = :potrazivanje"),
    @NamedQuery(name = "StrankePs.findByDugovanje", query = "SELECT s FROM StrankePs s WHERE s.dugovanje = :dugovanje")})
public class StrankePs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StrankePsPK strankePsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pstanje")
    private double pstanje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "potrazivanje")
    private double potrazivanje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dugovanje")
    private double dugovanje;
    @JoinColumn(name = "idstr", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Stranke stranke;

    public StrankePs() {
    }

    public StrankePs(StrankePsPK strankePsPK) {
        this.strankePsPK = strankePsPK;
    }

    public StrankePs(StrankePsPK strankePsPK, Date datum, double pstanje, double potrazivanje, double dugovanje) {
        this.strankePsPK = strankePsPK;
        this.datum = datum;
        this.pstanje = pstanje;
        this.potrazivanje = potrazivanje;
        this.dugovanje = dugovanje;
    }

    public StrankePs(int idstr, int idpred) {
        this.strankePsPK = new StrankePsPK(idstr, idpred);
    }

    public StrankePsPK getStrankePsPK() {
        return strankePsPK;
    }

    public void setStrankePsPK(StrankePsPK strankePsPK) {
        this.strankePsPK = strankePsPK;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getPstanje() {
        return pstanje;
    }

    public void setPstanje(double pstanje) {
        this.pstanje = pstanje;
    }

    public double getPotrazivanje() {
        return potrazivanje;
    }

    public void setPotrazivanje(double potrazivanje) {
        this.potrazivanje = potrazivanje;
    }

    public double getDugovanje() {
        return dugovanje;
    }

    public void setDugovanje(double dugovanje) {
        this.dugovanje = dugovanje;
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
        hash += (strankePsPK != null ? strankePsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StrankePs)) {
            return false;
        }
        StrankePs other = (StrankePs) object;
        if ((this.strankePsPK == null && other.strankePsPK != null) || (this.strankePsPK != null && !this.strankePsPK.equals(other.strankePsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StrankePs[ strankePsPK=" + strankePsPK + " ]";
    }
    
}
