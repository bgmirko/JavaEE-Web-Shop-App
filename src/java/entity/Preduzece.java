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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "preduzece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preduzece.findAll", query = "SELECT p FROM Preduzece p"),
    @NamedQuery(name = "Preduzece.findById", query = "SELECT p FROM Preduzece p WHERE p.id = :id"),
    @NamedQuery(name = "Preduzece.findByNaziv", query = "SELECT p FROM Preduzece p WHERE p.naziv = :naziv"),
    @NamedQuery(name = "Preduzece.findByAdresa", query = "SELECT p FROM Preduzece p WHERE p.adresa = :adresa"),
    @NamedQuery(name = "Preduzece.findByPib", query = "SELECT p FROM Preduzece p WHERE p.pib = :pib"),
    @NamedQuery(name = "Preduzece.findByTelefon", query = "SELECT p FROM Preduzece p WHERE p.telefon = :telefon"),
    @NamedQuery(name = "Preduzece.findByFax", query = "SELECT p FROM Preduzece p WHERE p.fax = :fax"),
    @NamedQuery(name = "Preduzece.findByMaticni", query = "SELECT p FROM Preduzece p WHERE p.maticni = :maticni"),
    @NamedQuery(name = "Preduzece.findByRegistarski", query = "SELECT p FROM Preduzece p WHERE p.registarski = :registarski"),
    @NamedQuery(name = "Preduzece.findBySifra", query = "SELECT p FROM Preduzece p WHERE p.sifra = :sifra"),
    @NamedQuery(name = "Preduzece.findByTekuci", query = "SELECT p FROM Preduzece p WHERE p.tekuci = :tekuci")})
public class Preduzece implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naziv")
    private String naziv;
    @Size(max = 45)
    @Column(name = "adresa")
    private String adresa;
    @Size(max = 45)
    @Column(name = "pib")
    private String pib;
    @Size(max = 45)
    @Column(name = "telefon")
    private String telefon;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "fax")
    private String fax;
    @Size(max = 45)
    @Column(name = "maticni")
    private String maticni;
    @Size(max = 45)
    @Column(name = "registarski")
    private String registarski;
    @Size(max = 45)
    @Column(name = "sifra")
    private String sifra;
    @Size(max = 45)
    @Column(name = "tekuci")
    private String tekuci;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpred")
    private Collection<PlacanjaU> placanjaUCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpred")
    private Collection<FaktureU> faktureUCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpred")
    private Collection<FakturePro> faktureProCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpred")
    private Collection<PlacanjaI> placanjaICollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpred")
    private Collection<FaktureI> faktureICollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpred")
    private Collection<Transferi> transferiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpred")
    private Collection<Magacini> magaciniCollection;

    public Preduzece() {
    }

    public Preduzece(Integer id) {
        this.id = id;
    }

    public Preduzece(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMaticni() {
        return maticni;
    }

    public void setMaticni(String maticni) {
        this.maticni = maticni;
    }

    public String getRegistarski() {
        return registarski;
    }

    public void setRegistarski(String registarski) {
        this.registarski = registarski;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getTekuci() {
        return tekuci;
    }

    public void setTekuci(String tekuci) {
        this.tekuci = tekuci;
    }

    @XmlTransient
    public Collection<PlacanjaU> getPlacanjaUCollection() {
        return placanjaUCollection;
    }

    public void setPlacanjaUCollection(Collection<PlacanjaU> placanjaUCollection) {
        this.placanjaUCollection = placanjaUCollection;
    }

    @XmlTransient
    public Collection<FaktureU> getFaktureUCollection() {
        return faktureUCollection;
    }

    public void setFaktureUCollection(Collection<FaktureU> faktureUCollection) {
        this.faktureUCollection = faktureUCollection;
    }

    @XmlTransient
    public Collection<FakturePro> getFaktureProCollection() {
        return faktureProCollection;
    }

    public void setFaktureProCollection(Collection<FakturePro> faktureProCollection) {
        this.faktureProCollection = faktureProCollection;
    }

    @XmlTransient
    public Collection<PlacanjaI> getPlacanjaICollection() {
        return placanjaICollection;
    }

    public void setPlacanjaICollection(Collection<PlacanjaI> placanjaICollection) {
        this.placanjaICollection = placanjaICollection;
    }

    @XmlTransient
    public Collection<FaktureI> getFaktureICollection() {
        return faktureICollection;
    }

    public void setFaktureICollection(Collection<FaktureI> faktureICollection) {
        this.faktureICollection = faktureICollection;
    }

    @XmlTransient
    public Collection<Transferi> getTransferiCollection() {
        return transferiCollection;
    }

    public void setTransferiCollection(Collection<Transferi> transferiCollection) {
        this.transferiCollection = transferiCollection;
    }

    @XmlTransient
    public Collection<Magacini> getMagaciniCollection() {
        return magaciniCollection;
    }

    public void setMagaciniCollection(Collection<Magacini> magaciniCollection) {
        this.magaciniCollection = magaciniCollection;
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
        if (!(object instanceof Preduzece)) {
            return false;
        }
        Preduzece other = (Preduzece) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Preduzece[ id=" + id + " ]";
    }
    
}
