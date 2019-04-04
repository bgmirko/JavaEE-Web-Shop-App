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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "stranke")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stranke.findAll", query = "SELECT s FROM Stranke s"),
    @NamedQuery(name = "Stranke.findById", query = "SELECT s FROM Stranke s WHERE s.id = :id"),
    @NamedQuery(name = "Stranke.findBySifra", query = "SELECT s FROM Stranke s WHERE s.sifra = :sifra"),
    @NamedQuery(name = "Stranke.findByOsoba", query = "SELECT s FROM Stranke s WHERE s.osoba = :osoba"),
    @NamedQuery(name = "Stranke.findByPreduzece", query = "SELECT s FROM Stranke s WHERE s.preduzece = :preduzece"),
    @NamedQuery(name = "Stranke.findByGrad", query = "SELECT s FROM Stranke s WHERE s.grad = :grad"),
    @NamedQuery(name = "Stranke.findByAdresa", query = "SELECT s FROM Stranke s WHERE s.adresa = :adresa"),
    @NamedQuery(name = "Stranke.findByPib", query = "SELECT s FROM Stranke s WHERE s.pib = :pib"),
    @NamedQuery(name = "Stranke.findByTel1", query = "SELECT s FROM Stranke s WHERE s.tel1 = :tel1"),
    @NamedQuery(name = "Stranke.findByTel2", query = "SELECT s FROM Stranke s WHERE s.tel2 = :tel2"),
    @NamedQuery(name = "Stranke.findByTel3", query = "SELECT s FROM Stranke s WHERE s.tel3 = :tel3"),
    @NamedQuery(name = "Stranke.findByTelM", query = "SELECT s FROM Stranke s WHERE s.telM = :telM"),
    @NamedQuery(name = "Stranke.findByKomentar", query = "SELECT s FROM Stranke s WHERE s.komentar = :komentar"),
    @NamedQuery(name = "Stranke.findByExtFile", query = "SELECT s FROM Stranke s WHERE s.extFile = :extFile"),
    @NamedQuery(name = "Stranke.findByValuta", query = "SELECT s FROM Stranke s WHERE s.valuta = :valuta"),
    @NamedQuery(name = "Stranke.findByMaksimum", query = "SELECT s FROM Stranke s WHERE s.maksimum = :maksimum"),
    @NamedQuery(name = "Stranke.findByVisible", query = "SELECT s FROM Stranke s WHERE s.visible = :visible"),
    @NamedQuery(name = "Stranke.findByDrzava", query = "SELECT s FROM Stranke s WHERE s.drzava = :drzava")})
public class Stranke implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "Sifra")
    private String sifra;
    @Size(max = 25)
    @Column(name = "Osoba")
    private String osoba;
    @Size(max = 25)
    @Column(name = "Preduzece")
    private String preduzece;
    @Size(max = 15)
    @Column(name = "Grad")
    private String grad;
    @Size(max = 25)
    @Column(name = "Adresa")
    private String adresa;
    @Size(max = 10)
    @Column(name = "PIB")
    private String pib;
    @Size(max = 16)
    @Column(name = "Tel1")
    private String tel1;
    @Size(max = 16)
    @Column(name = "Tel2")
    private String tel2;
    @Size(max = 16)
    @Column(name = "Tel3")
    private String tel3;
    @Size(max = 16)
    @Column(name = "TelM")
    private String telM;
    @Size(max = 50)
    @Column(name = "Komentar")
    private String komentar;
    @Size(max = 100)
    @Column(name = "ExtFile")
    private String extFile;
    @Column(name = "Valuta")
    private Integer valuta;
    @Column(name = "maksimum")
    private Integer maksimum;
    @Column(name = "visible")
    private Boolean visible;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "drzava")
    private String drzava;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstr")
    private Collection<PlacanjaU> placanjaUCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstr")
    private Collection<FaktureU> faktureUCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstr")
    private Collection<FakturePro> faktureProCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stranke")
    private Collection<StrankePs> strankePsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstr")
    private Collection<PlacanjaI> placanjaICollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstr")
    private Collection<FaktureI> faktureICollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stranke")
    private Collection<StrankeCen> strankeCenCollection;
    @JoinColumn(name = "idgrp", referencedColumnName = "id")
    @ManyToOne
    private StrankeGrp idgrp;

    public Stranke() {
    }

    public Stranke(Integer id) {
        this.id = id;
    }

    public Stranke(Integer id, String drzava) {
        this.id = id;
        this.drzava = drzava;
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

    public String getOsoba() {
        return osoba;
    }

    public void setOsoba(String osoba) {
        this.osoba = osoba;
    }

    public String getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(String preduzece) {
        this.preduzece = preduzece;
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

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    public String getTelM() {
        return telM;
    }

    public void setTelM(String telM) {
        this.telM = telM;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getExtFile() {
        return extFile;
    }

    public void setExtFile(String extFile) {
        this.extFile = extFile;
    }

    public Integer getValuta() {
        return valuta;
    }

    public void setValuta(Integer valuta) {
        this.valuta = valuta;
    }

    public Integer getMaksimum() {
        return maksimum;
    }

    public void setMaksimum(Integer maksimum) {
        this.maksimum = maksimum;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
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
    public Collection<StrankePs> getStrankePsCollection() {
        return strankePsCollection;
    }

    public void setStrankePsCollection(Collection<StrankePs> strankePsCollection) {
        this.strankePsCollection = strankePsCollection;
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
    public Collection<StrankeCen> getStrankeCenCollection() {
        return strankeCenCollection;
    }

    public void setStrankeCenCollection(Collection<StrankeCen> strankeCenCollection) {
        this.strankeCenCollection = strankeCenCollection;
    }

    public StrankeGrp getIdgrp() {
        return idgrp;
    }

    public void setIdgrp(StrankeGrp idgrp) {
        this.idgrp = idgrp;
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
        if (!(object instanceof Stranke)) {
            return false;
        }
        Stranke other = (Stranke) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Stranke[ id=" + id + " ]";
    }
    
}
