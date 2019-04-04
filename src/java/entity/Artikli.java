/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "artikli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikli.findByPartOfText", query = "SELECT a FROM Artikli a WHERE a.naziv like :search OR a.sifra like :search"),
    @NamedQuery(name = "Artikli.findAll", query = "SELECT a FROM Artikli a"),
    @NamedQuery(name = "Artikli.findById", query = "SELECT a FROM Artikli a WHERE a.id = :id"),
    @NamedQuery(name = "Artikli.findBySifra", query = "SELECT a FROM Artikli a WHERE a.sifra = :sifra"),
    @NamedQuery(name = "Artikli.findByNaziv", query = "SELECT a FROM Artikli a WHERE a.naziv = :naziv"),
    @NamedQuery(name = "Artikli.findByJMere", query = "SELECT a FROM Artikli a WHERE a.jMere = :jMere"),
    @NamedQuery(name = "Artikli.findByKomentar", query = "SELECT a FROM Artikli a WHERE a.komentar = :komentar"),
    @NamedQuery(name = "Artikli.findByMinimum", query = "SELECT a FROM Artikli a WHERE a.minimum = :minimum"),
    @NamedQuery(name = "Artikli.findByUsluga", query = "SELECT a FROM Artikli a WHERE a.usluga = :usluga"),
    @NamedQuery(name = "Artikli.findByVisible", query = "SELECT a FROM Artikli a WHERE a.visible = :visible"),
    @NamedQuery(name = "Artikli.findByNabavna", query = "SELECT a FROM Artikli a WHERE a.nabavna = :nabavna"),
    @NamedQuery(name = "Artikli.findByCena", query = "SELECT a FROM Artikli a WHERE a.cena = :cena"),
    @NamedQuery(name = "Artikli.findByCenovnik", query = "SELECT a FROM Artikli a WHERE a.cenovnik = :cenovnik"),
    @NamedQuery(name = "Artikli.findByBarcode", query = "SELECT a FROM Artikli a WHERE a.barcode = :barcode")})
public class Artikli implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "Sifra")
    private String sifra;
    @Size(max = 200)
    @Column(name = "Naziv")
    private String naziv;
    @Size(max = 4)
    @Column(name = "JMere")
    private String jMere;
    @Size(max = 50)
    @Column(name = "Komentar")
    private String komentar;
    @Column(name = "minimum")
    private Integer minimum;
    @Column(name = "usluga")
    private Boolean usluga;
    @Column(name = "visible")
    private Boolean visible;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nabavna")
    private Float nabavna;
    @Column(name = "cena")
    private Float cena;
    @Column(name = "cenovnik")
    private Boolean cenovnik;
    @Size(max = 15)
    @Column(name = "barcode")
    private String barcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikli")
    private Collection<Trastavke> trastavkeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikli")
    private Collection<FakstavkeI> fakstavkeICollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikli")
    private Collection<FakstavkePro> fakstavkeProCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikli")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ArtikliPs> artikliPsCollection;
    @JoinColumn(name = "idpdv", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pdv idpdv;
    @JoinColumn(name = "idpro", referencedColumnName = "id")
    @ManyToOne
    private ArtikliFrm idpro;
    @JoinColumn(name = "idgrp", referencedColumnName = "id")
    @ManyToOne
    private ArtikliGrp idgrp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikli")
    private Collection<FakstavkeU> fakstavkeUCollection;

    @Transient
    public int getNaLageru(){
        Collection<ArtikliPs> artikalStanjeCollection;
        artikalStanjeCollection = this.getArtikliPsCollection();
        int ukupnoStanje=0;
        for (ArtikliPs artikalPs : artikalStanjeCollection) {
            ukupnoStanje+=artikalPs.getPstanje()+artikalPs.getUlaz()-artikalPs.getIzlaz();
        }      
        return ukupnoStanje;       
    }
    
    
    public Artikli() {
    }

    
    public Artikli(Integer id) {
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

    public String getJMere() {
        return jMere;
    }

    public void setJMere(String jMere) {
        this.jMere = jMere;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Boolean getUsluga() {
        return usluga;
    }

    public void setUsluga(Boolean usluga) {
        this.usluga = usluga;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Float getNabavna() {
        return nabavna;
    }

    public void setNabavna(Float nabavna) {
        this.nabavna = nabavna;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public Boolean getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(Boolean cenovnik) {
        this.cenovnik = cenovnik;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @XmlTransient
    public Collection<Trastavke> getTrastavkeCollection() {
        return trastavkeCollection;
    }

    public void setTrastavkeCollection(Collection<Trastavke> trastavkeCollection) {
        this.trastavkeCollection = trastavkeCollection;
    }

    @XmlTransient
    public Collection<FakstavkeI> getFakstavkeICollection() {
        return fakstavkeICollection;
    }

    public void setFakstavkeICollection(Collection<FakstavkeI> fakstavkeICollection) {
        this.fakstavkeICollection = fakstavkeICollection;
    }

    @XmlTransient
    public Collection<FakstavkePro> getFakstavkeProCollection() {
        return fakstavkeProCollection;
    }

    public void setFakstavkeProCollection(Collection<FakstavkePro> fakstavkeProCollection) {
        this.fakstavkeProCollection = fakstavkeProCollection;
    }

    @XmlTransient
    public Collection<ArtikliPs> getArtikliPsCollection() {
        return artikliPsCollection;
    }

    public void setArtikliPsCollection(Collection<ArtikliPs> artikliPsCollection) {
        this.artikliPsCollection = artikliPsCollection;
    }
 
    public Pdv getIdpdv() {
        return idpdv;
    }

    public void setIdpdv(Pdv idpdv) {
        this.idpdv = idpdv;
    }

    public ArtikliFrm getIdpro() {
        return idpro;
    }

    public void setIdpro(ArtikliFrm idpro) {
        this.idpro = idpro;
    }

    public ArtikliGrp getIdgrp() {
        return idgrp;
    }

    public void setIdgrp(ArtikliGrp idgrp) {
        this.idgrp = idgrp;
    }

    @XmlTransient
    public Collection<FakstavkeU> getFakstavkeUCollection() {
        return fakstavkeUCollection;
    }

    public void setFakstavkeUCollection(Collection<FakstavkeU> fakstavkeUCollection) {
        this.fakstavkeUCollection = fakstavkeUCollection;
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
        if (!(object instanceof Artikli)) {
            return false;
        }
        Artikli other = (Artikli) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Artikli[ id=" + id + " ]";
    }
    
}
