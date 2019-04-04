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
@Table(name = "fakstavke_pro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FakstavkePro.findAll", query = "SELECT f FROM FakstavkePro f"),
    @NamedQuery(name = "FakstavkePro.findByIdfak", query = "SELECT f FROM FakstavkePro f WHERE f.fakstavkeProPK.idfak = :idfak"),
    @NamedQuery(name = "FakstavkePro.findByIdart", query = "SELECT f FROM FakstavkePro f WHERE f.fakstavkeProPK.idart = :idart"),
    @NamedQuery(name = "FakstavkePro.findByKolicina", query = "SELECT f FROM FakstavkePro f WHERE f.kolicina = :kolicina"),
    @NamedQuery(name = "FakstavkePro.findByCena", query = "SELECT f FROM FakstavkePro f WHERE f.cena = :cena"),
    @NamedQuery(name = "FakstavkePro.findByNabavna", query = "SELECT f FROM FakstavkePro f WHERE f.nabavna = :nabavna"),
    @NamedQuery(name = "FakstavkePro.findByRabat", query = "SELECT f FROM FakstavkePro f WHERE f.rabat = :rabat"),
    @NamedQuery(name = "FakstavkePro.findByCenaStr", query = "SELECT f FROM FakstavkePro f WHERE f.cenaStr = :cenaStr"),
    @NamedQuery(name = "FakstavkePro.findByPdv", query = "SELECT f FROM FakstavkePro f WHERE f.pdv = :pdv")})
public class FakstavkePro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FakstavkeProPK fakstavkeProPK;
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
    private FakturePro fakturePro;

    public FakstavkePro() {
    }

    public FakstavkePro(FakstavkeProPK fakstavkeProPK) {
        this.fakstavkeProPK = fakstavkeProPK;
    }

    public FakstavkePro(FakstavkeProPK fakstavkeProPK, double kolicina, double cena, double nabavna, double cenaStr, int pdv) {
        this.fakstavkeProPK = fakstavkeProPK;
        this.kolicina = kolicina;
        this.cena = cena;
        this.nabavna = nabavna;
        this.cenaStr = cenaStr;
        this.pdv = pdv;
    }

    public FakstavkePro(int idfak, int idart) {
        this.fakstavkeProPK = new FakstavkeProPK(idfak, idart);
    }

    public FakstavkeProPK getFakstavkeProPK() {
        return fakstavkeProPK;
    }

    public void setFakstavkeProPK(FakstavkeProPK fakstavkeProPK) {
        this.fakstavkeProPK = fakstavkeProPK;
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

    public FakturePro getFakturePro() {
        return fakturePro;
    }

    public void setFakturePro(FakturePro fakturePro) {
        this.fakturePro = fakturePro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fakstavkeProPK != null ? fakstavkeProPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FakstavkePro)) {
            return false;
        }
        FakstavkePro other = (FakstavkePro) object;
        if ((this.fakstavkeProPK == null && other.fakstavkeProPK != null) || (this.fakstavkeProPK != null && !this.fakstavkeProPK.equals(other.fakstavkeProPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FakstavkePro[ fakstavkeProPK=" + fakstavkeProPK + " ]";
    }
    
}
