/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "magacini")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Magacini.findAll", query = "SELECT m FROM Magacini m"),
    @NamedQuery(name = "Magacini.findById", query = "SELECT m FROM Magacini m WHERE m.id = :id"),
    @NamedQuery(name = "Magacini.findBySifra", query = "SELECT m FROM Magacini m WHERE m.sifra = :sifra"),
    @NamedQuery(name = "Magacini.findByNaziv", query = "SELECT m FROM Magacini m WHERE m.naziv = :naziv"),
    @NamedQuery(name = "Magacini.findByGrad", query = "SELECT m FROM Magacini m WHERE m.grad = :grad"),
    @NamedQuery(name = "Magacini.findByAdresa", query = "SELECT m FROM Magacini m WHERE m.adresa = :adresa"),
    @NamedQuery(name = "Magacini.findByKomentar", query = "SELECT m FROM Magacini m WHERE m.komentar = :komentar")})
public class Magacini implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "Sifra")
    private String sifra;
    @Size(max = 20)
    @Column(name = "Naziv")
    private String naziv;
    @Size(max = 15)
    @Column(name = "Grad")
    private String grad;
    @Size(max = 25)
    @Column(name = "Adresa")
    private String adresa;
    @Size(max = 20)
    @Column(name = "Komentar")
    private String komentar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magacini")
    private Collection<ArtikliPs> artikliPsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmag2")
    private Collection<Transferi> transferiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmag")
    private Collection<Transferi> transferiCollection1;
    @JoinColumn(name = "idpred", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Preduzece idpred;

    public Magacini() {
    }

    public Magacini(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    @XmlTransient
    public Collection<ArtikliPs> getArtikliPsCollection() {
        return artikliPsCollection;
    }

    public void setArtikliPsCollection(Collection<ArtikliPs> artikliPsCollection) {
        this.artikliPsCollection = artikliPsCollection;
    }

    @XmlTransient
    public Collection<Transferi> getTransferiCollection() {
        return transferiCollection;
    }

    public void setTransferiCollection(Collection<Transferi> transferiCollection) {
        this.transferiCollection = transferiCollection;
    }

    @XmlTransient
    public Collection<Transferi> getTransferiCollection1() {
        return transferiCollection1;
    }

    public void setTransferiCollection1(Collection<Transferi> transferiCollection1) {
        this.transferiCollection1 = transferiCollection1;
    }

    public Preduzece getIdpred() {
        return idpred;
    }

    public void setIdpred(Preduzece idpred) {
        this.idpred = idpred;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magacini)) {
            return false;
        }
        Magacini other = (Magacini) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Magacini[ id=" + id + " ]";
    }
    
}
