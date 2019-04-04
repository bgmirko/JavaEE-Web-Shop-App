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
@Table(name = "fakstavke_u")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FakstavkeU.findAll", query = "SELECT f FROM FakstavkeU f"),
    @NamedQuery(name = "FakstavkeU.findByIdfak", query = "SELECT f FROM FakstavkeU f WHERE f.fakstavkeUPK.idfak = :idfak"),
    @NamedQuery(name = "FakstavkeU.findByIdart", query = "SELECT f FROM FakstavkeU f WHERE f.fakstavkeUPK.idart = :idart"),
    @NamedQuery(name = "FakstavkeU.findByKolicina", query = "SELECT f FROM FakstavkeU f WHERE f.kolicina = :kolicina"),
    @NamedQuery(name = "FakstavkeU.findByCena", query = "SELECT f FROM FakstavkeU f WHERE f.cena = :cena"),
    @NamedQuery(name = "FakstavkeU.findByNabavna", query = "SELECT f FROM FakstavkeU f WHERE f.nabavna = :nabavna"),
    @NamedQuery(name = "FakstavkeU.findByRabat", query = "SELECT f FROM FakstavkeU f WHERE f.rabat = :rabat"),
    @NamedQuery(name = "FakstavkeU.findByCenaStr", query = "SELECT f FROM FakstavkeU f WHERE f.cenaStr = :cenaStr"),
    @NamedQuery(name = "FakstavkeU.findByPdv", query = "SELECT f FROM FakstavkeU f WHERE f.pdv = :pdv"),
    @NamedQuery(name = "FakstavkeU.findByTrosak", query = "SELECT f FROM FakstavkeU f WHERE f.trosak = :trosak"),
    @NamedQuery(name = "FakstavkeU.findByTrosak1", query = "SELECT f FROM FakstavkeU f WHERE f.trosak1 = :trosak1"),
    @NamedQuery(name = "FakstavkeU.findByMarza", query = "SELECT f FROM FakstavkeU f WHERE f.marza = :marza"),
    @NamedQuery(name = "FakstavkeU.findByMarza1", query = "SELECT f FROM FakstavkeU f WHERE f.marza1 = :marza1"),
    @NamedQuery(name = "FakstavkeU.findByVpc", query = "SELECT f FROM FakstavkeU f WHERE f.vpc = :vpc"),
    @NamedQuery(name = "FakstavkeU.findByMpc", query = "SELECT f FROM FakstavkeU f WHERE f.mpc = :mpc")})
public class FakstavkeU implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FakstavkeUPK fakstavkeUPK;
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
    @Column(name = "CenaStr")
    private Double cenaStr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pdv")
    private int pdv;
    @Column(name = "trosak%")
    private Double trosak;
    @Column(name = "trosak")
    private Double trosak1;
    @Column(name = "marza%")
    private Double marza;
    @Column(name = "marza")
    private Double marza1;
    @Column(name = "vpc")
    private Double vpc;
    @Column(name = "mpc")
    private Double mpc;
    @JoinColumn(name = "idart", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikli artikli;
    @JoinColumn(name = "idfak", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FaktureU faktureU;

    public FakstavkeU() {
    }

    public FakstavkeU(FakstavkeUPK fakstavkeUPK) {
        this.fakstavkeUPK = fakstavkeUPK;
    }

    public FakstavkeU(FakstavkeUPK fakstavkeUPK, double kolicina, double cena, double nabavna, int pdv) {
        this.fakstavkeUPK = fakstavkeUPK;
        this.kolicina = kolicina;
        this.cena = cena;
        this.nabavna = nabavna;
        this.pdv = pdv;
    }

    public FakstavkeU(int idfak, int idart) {
        this.fakstavkeUPK = new FakstavkeUPK(idfak, idart);
    }

    public FakstavkeUPK getFakstavkeUPK() {
        return fakstavkeUPK;
    }

    public void setFakstavkeUPK(FakstavkeUPK fakstavkeUPK) {
        this.fakstavkeUPK = fakstavkeUPK;
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

    public Double getCenaStr() {
        return cenaStr;
    }

    public void setCenaStr(Double cenaStr) {
        this.cenaStr = cenaStr;
    }

    public int getPdv() {
        return pdv;
    }

    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    public Double getTrosak() {
        return trosak;
    }

    public void setTrosak(Double trosak) {
        this.trosak = trosak;
    }

    public Double getTrosak1() {
        return trosak1;
    }

    public void setTrosak1(Double trosak1) {
        this.trosak1 = trosak1;
    }

    public Double getMarza() {
        return marza;
    }

    public void setMarza(Double marza) {
        this.marza = marza;
    }

    public Double getMarza1() {
        return marza1;
    }

    public void setMarza1(Double marza1) {
        this.marza1 = marza1;
    }

    public Double getVpc() {
        return vpc;
    }

    public void setVpc(Double vpc) {
        this.vpc = vpc;
    }

    public Double getMpc() {
        return mpc;
    }

    public void setMpc(Double mpc) {
        this.mpc = mpc;
    }

    public Artikli getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
    }

    public FaktureU getFaktureU() {
        return faktureU;
    }

    public void setFaktureU(FaktureU faktureU) {
        this.faktureU = faktureU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fakstavkeUPK != null ? fakstavkeUPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FakstavkeU)) {
            return false;
        }
        FakstavkeU other = (FakstavkeU) object;
        if ((this.fakstavkeUPK == null && other.fakstavkeUPK != null) || (this.fakstavkeUPK != null && !this.fakstavkeUPK.equals(other.fakstavkeUPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FakstavkeU[ fakstavkeUPK=" + fakstavkeUPK + " ]";
    }
    
}
