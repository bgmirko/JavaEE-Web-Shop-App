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
@Table(name = "artikli_ps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtikliPs.findAll", query = "SELECT a FROM ArtikliPs a"),
    @NamedQuery(name = "ArtikliPs.findByIdart", query = "SELECT a FROM ArtikliPs a WHERE a.artikliPsPK.idart = :idart"),
    @NamedQuery(name = "ArtikliPs.findByIdmag", query = "SELECT a FROM ArtikliPs a WHERE a.artikliPsPK.idmag = :idmag"),
    @NamedQuery(name = "ArtikliPs.findByDatum", query = "SELECT a FROM ArtikliPs a WHERE a.datum = :datum"),
    @NamedQuery(name = "ArtikliPs.findByPstanje", query = "SELECT a FROM ArtikliPs a WHERE a.pstanje = :pstanje"),
    @NamedQuery(name = "ArtikliPs.findByPnabavna", query = "SELECT a FROM ArtikliPs a WHERE a.pnabavna = :pnabavna"),
    @NamedQuery(name = "ArtikliPs.findByUlaz", query = "SELECT a FROM ArtikliPs a WHERE a.ulaz = :ulaz"),
    @NamedQuery(name = "ArtikliPs.findByIzlaz", query = "SELECT a FROM ArtikliPs a WHERE a.izlaz = :izlaz")})
public class ArtikliPs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArtikliPsPK artikliPsPK;
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
    @Column(name = "pnabavna")
    private double pnabavna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ulaz")
    private double ulaz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "izlaz")
    private double izlaz;
    @JoinColumn(name = "idmag", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Magacini magacini;
    @JoinColumn(name = "idart", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikli artikli;

    public ArtikliPs() {
    }

    public ArtikliPs(ArtikliPsPK artikliPsPK) {
        this.artikliPsPK = artikliPsPK;
    }

    public ArtikliPs(ArtikliPsPK artikliPsPK, Date datum, double pstanje, double pnabavna, double ulaz, double izlaz) {
        this.artikliPsPK = artikliPsPK;
        this.datum = datum;
        this.pstanje = pstanje;
        this.pnabavna = pnabavna;
        this.ulaz = ulaz;
        this.izlaz = izlaz;
    }

    public ArtikliPs(int idart, int idmag) {
        this.artikliPsPK = new ArtikliPsPK(idart, idmag);
    }

    public ArtikliPsPK getArtikliPsPK() {
        return artikliPsPK;
    }

    public void setArtikliPsPK(ArtikliPsPK artikliPsPK) {
        this.artikliPsPK = artikliPsPK;
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

    public double getPnabavna() {
        return pnabavna;
    }

    public void setPnabavna(double pnabavna) {
        this.pnabavna = pnabavna;
    }

    public double getUlaz() {
        return ulaz;
    }

    public void setUlaz(double ulaz) {
        this.ulaz = ulaz;
    }

    public double getIzlaz() {
        return izlaz;
    }

    public void setIzlaz(double izlaz) {
        this.izlaz = izlaz;
    }

    public Magacini getMagacini() {
        return magacini;
    }

    public void setMagacini(Magacini magacini) {
        this.magacini = magacini;
    }

    public Artikli getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artikliPsPK != null ? artikliPsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtikliPs)) {
            return false;
        }
        ArtikliPs other = (ArtikliPs) object;
        if ((this.artikliPsPK == null && other.artikliPsPK != null) || (this.artikliPsPK != null && !this.artikliPsPK.equals(other.artikliPsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ArtikliPs[ artikliPsPK=" + artikliPsPK + " ]";
    }
    
}
