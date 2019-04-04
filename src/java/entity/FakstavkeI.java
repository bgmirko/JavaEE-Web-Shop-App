/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "fakstavke_i")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FakstavkeI.findAll", query = "SELECT f FROM FakstavkeI f"),
    @NamedQuery(name = "FakstavkeI.findByIdfak", query = "SELECT f FROM FakstavkeI f WHERE f.fakstavkeIPK.idfak = :idfak"),
    @NamedQuery(name = "FakstavkeI.findByIdart", query = "SELECT f FROM FakstavkeI f WHERE f.fakstavkeIPK.idart = :idart"),
    @NamedQuery(name = "FakstavkeI.findByKolicina", query = "SELECT f FROM FakstavkeI f WHERE f.kolicina = :kolicina"),
    @NamedQuery(name = "FakstavkeI.findByCena", query = "SELECT f FROM FakstavkeI f WHERE f.cena = :cena"),
    @NamedQuery(name = "FakstavkeI.findByNabavna", query = "SELECT f FROM FakstavkeI f WHERE f.nabavna = :nabavna"),
    @NamedQuery(name = "FakstavkeI.findByRabat", query = "SELECT f FROM FakstavkeI f WHERE f.rabat = :rabat"),
    @NamedQuery(name = "FakstavkeI.findByCenaStr", query = "SELECT f FROM FakstavkeI f WHERE f.cenaStr = :cenaStr"),
    @NamedQuery(name = "FakstavkeI.findByPdv", query = "SELECT f FROM FakstavkeI f WHERE f.pdv = :pdv")})
public class FakstavkeI implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FakstavkeIPK fakstavkeIPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Kolicina")
    private double kolicina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cena")
    private double cena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nabavna")
    private double nabavna;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Rabat")
    private Double rabat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CenaStr")
    private double cenaStr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pdv")
    private int pdv;
    @JoinColumn(name = "idart", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikli artikli;
    @JoinColumn(name = "idfak", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FaktureI faktureI;

    public FakstavkeI() {
    }

    public FakstavkeI(FakstavkeIPK fakstavkeIPK) {
        this.fakstavkeIPK = fakstavkeIPK;
    }

    public FakstavkeI(FakstavkeIPK fakstavkeIPK, double kolicina, double cena, double nabavna, double cenaStr, int pdv) {
        this.fakstavkeIPK = fakstavkeIPK;
        this.kolicina = kolicina;
        this.cena = cena;
        this.nabavna = nabavna;
        this.cenaStr = cenaStr;
        this.pdv = pdv;
    }

    public FakstavkeI(int idfak, int idart) {
        this.fakstavkeIPK = new FakstavkeIPK(idfak, idart);
    }

    public FakstavkeIPK getFakstavkeIPK() {
        return fakstavkeIPK;
    }

    public void setFakstavkeIPK(FakstavkeIPK fakstavkeIPK) {
        this.fakstavkeIPK = fakstavkeIPK;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getNabavna() {
        return nabavna;
    }

    public void setNabavna(double nabavna) {
        this.nabavna = nabavna;
    }

    public Double getRabat() {
        return rabat;
    }

    public void setRabat(Double rabat) {
        this.rabat = rabat;
    }

    public double getCenaStr() {
        return cenaStr;
    }

    public void setCenaStr(double cenaStr) {
        this.cenaStr = cenaStr;
    }

    public int getPdv() {
        return pdv;
    }

    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    public Artikli getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
    }

    public FaktureI getFaktureI() {
        return faktureI;
    }

    public void setFaktureI(FaktureI faktureI) {
        this.faktureI = faktureI;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fakstavkeIPK != null ? fakstavkeIPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FakstavkeI)) {
            return false;
        }
        FakstavkeI other = (FakstavkeI) object;
        if ((this.fakstavkeIPK == null && other.fakstavkeIPK != null) || (this.fakstavkeIPK != null && !this.fakstavkeIPK.equals(other.fakstavkeIPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FakstavkeI[ fakstavkeIPK=" + fakstavkeIPK + " ]";
    }
    
}
