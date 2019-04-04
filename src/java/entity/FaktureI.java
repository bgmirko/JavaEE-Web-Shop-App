/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "fakture_i")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaktureI.findAll", query = "SELECT f FROM FaktureI f"),
    @NamedQuery(name = "FaktureI.findById", query = "SELECT f FROM FaktureI f WHERE f.id = :id"),
    @NamedQuery(name = "FaktureI.findByBrOtpremnice", query = "SELECT f FROM FaktureI f WHERE f.brOtpremnice = :brOtpremnice"),
    @NamedQuery(name = "FaktureI.findByBrFakture", query = "SELECT f FROM FaktureI f WHERE f.brFakture = :brFakture"),
    @NamedQuery(name = "FaktureI.findByDatum", query = "SELECT f FROM FaktureI f WHERE f.datum = :datum"),
    @NamedQuery(name = "FaktureI.findByKomentar", query = "SELECT f FROM FaktureI f WHERE f.komentar = :komentar"),
    @NamedQuery(name = "FaktureI.findByKurs", query = "SELECT f FROM FaktureI f WHERE f.kurs = :kurs"),
    @NamedQuery(name = "FaktureI.findByVrednost", query = "SELECT f FROM FaktureI f WHERE f.vrednost = :vrednost"),
    @NamedQuery(name = "FaktureI.findByUneo", query = "SELECT f FROM FaktureI f WHERE f.uneo = :uneo"),
    @NamedQuery(name = "FaktureI.findByUneoDatum", query = "SELECT f FROM FaktureI f WHERE f.uneoDatum = :uneoDatum"),
    @NamedQuery(name = "FaktureI.findByIzmenio", query = "SELECT f FROM FaktureI f WHERE f.izmenio = :izmenio"),
    @NamedQuery(name = "FaktureI.findByIzmenioDatum", query = "SELECT f FROM FaktureI f WHERE f.izmenioDatum = :izmenioDatum"),
    @NamedQuery(name = "FaktureI.findByStorno", query = "SELECT f FROM FaktureI f WHERE f.storno = :storno"),
    @NamedQuery(name = "FaktureI.findByValuta", query = "SELECT f FROM FaktureI f WHERE f.valuta = :valuta"),
    @NamedQuery(name = "FaktureI.findByDatumPrometa", query = "SELECT f FROM FaktureI f WHERE f.datumPrometa = :datumPrometa"),
    @NamedQuery(name = "FaktureI.findByIdmag", query = "SELECT f FROM FaktureI f WHERE f.idmag = :idmag"),
    @NamedQuery(name = "FaktureI.findByMesto", query = "SELECT f FROM FaktureI f WHERE f.mesto = :mesto"),
    @NamedQuery(name = "FaktureI.findByNapomenaporez", query = "SELECT f FROM FaktureI f WHERE f.napomenaporez = :napomenaporez"),
    @NamedQuery(name = "FaktureI.findByValutna", query = "SELECT f FROM FaktureI f WHERE f.valutna = :valutna"),
    @NamedQuery(name = "FaktureI.findByValutnavaluta", query = "SELECT f FROM FaktureI f WHERE f.valutnavaluta = :valutnavaluta"),
    @NamedQuery(name = "FaktureI.findByKorisnik", query = "SELECT f FROM FaktureI f WHERE f.korisnik = :korisnik")})
public class FaktureI implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "BrOtpremnice")
    private String brOtpremnice;
    @Size(max = 10)
    @Column(name = "BrFakture")
    private String brFakture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Size(max = 200)
    @Column(name = "Komentar")
    private String komentar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Kurs")
    private double kurs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vrednost")
    private double vrednost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Uneo")
    private String uneo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UneoDatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uneoDatum;
    @Size(max = 8)
    @Column(name = "Izmenio")
    private String izmenio;
    @Column(name = "IzmenioDatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date izmenioDatum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Storno")
    private String storno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valuta")
    @Temporal(TemporalType.DATE)
    private Date valuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DatumPrometa")
    @Temporal(TemporalType.DATE)
    private Date datumPrometa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmag")
    private int idmag;
    @Size(max = 30)
    @Column(name = "mesto")
    private String mesto;
    @Size(max = 200)
    @Column(name = "napomenaporez")
    private String napomenaporez;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valutna")
    private boolean valutna;
    @Size(max = 3)
    @Column(name = "valutnavaluta")
    private String valutnavaluta;
    @Size(max = 45)
    @Column(name = "korisnik")
    private String korisnik;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faktureI")
    private Collection<FakstavkeI> fakstavkeICollection;
    @JoinColumn(name = "idpred", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Preduzece idpred;
    @JoinColumn(name = "idstr", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stranke idstr;

    public FaktureI() {
    }

    public FaktureI(Integer id) {
        this.id = id;
    }

    public FaktureI(Integer id, Date datum, double kurs, double vrednost, String uneo, Date uneoDatum, String storno, Date valuta, Date datumPrometa, int idmag, boolean valutna) {
        this.id = id;
        this.datum = datum;
        this.kurs = kurs;
        this.vrednost = vrednost;
        this.uneo = uneo;
        this.uneoDatum = uneoDatum;
        this.storno = storno;
        this.valuta = valuta;
        this.datumPrometa = datumPrometa;
        this.idmag = idmag;
        this.valutna = valutna;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrOtpremnice() {
        return brOtpremnice;
    }

    public void setBrOtpremnice(String brOtpremnice) {
        this.brOtpremnice = brOtpremnice;
    }

    public String getBrFakture() {
        return brFakture;
    }

    public void setBrFakture(String brFakture) {
        this.brFakture = brFakture;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public double getKurs() {
        return kurs;
    }

    public void setKurs(double kurs) {
        this.kurs = kurs;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public String getUneo() {
        return uneo;
    }

    public void setUneo(String uneo) {
        this.uneo = uneo;
    }

    public Date getUneoDatum() {
        return uneoDatum;
    }

    public void setUneoDatum(Date uneoDatum) {
        this.uneoDatum = uneoDatum;
    }

    public String getIzmenio() {
        return izmenio;
    }

    public void setIzmenio(String izmenio) {
        this.izmenio = izmenio;
    }

    public Date getIzmenioDatum() {
        return izmenioDatum;
    }

    public void setIzmenioDatum(Date izmenioDatum) {
        this.izmenioDatum = izmenioDatum;
    }

    public String getStorno() {
        return storno;
    }

    public void setStorno(String storno) {
        this.storno = storno;
    }

    public Date getValuta() {
        return valuta;
    }

    public void setValuta(Date valuta) {
        this.valuta = valuta;
    }

    public Date getDatumPrometa() {
        return datumPrometa;
    }

    public void setDatumPrometa(Date datumPrometa) {
        this.datumPrometa = datumPrometa;
    }

    public int getIdmag() {
        return idmag;
    }

    public void setIdmag(int idmag) {
        this.idmag = idmag;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getNapomenaporez() {
        return napomenaporez;
    }

    public void setNapomenaporez(String napomenaporez) {
        this.napomenaporez = napomenaporez;
    }

    public boolean getValutna() {
        return valutna;
    }

    public void setValutna(boolean valutna) {
        this.valutna = valutna;
    }

    public String getValutnavaluta() {
        return valutnavaluta;
    }

    public void setValutnavaluta(String valutnavaluta) {
        this.valutnavaluta = valutnavaluta;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    @XmlTransient
    public Collection<FakstavkeI> getFakstavkeICollection() {
        return fakstavkeICollection;
    }

    public void setFakstavkeICollection(Collection<FakstavkeI> fakstavkeICollection) {
        this.fakstavkeICollection = fakstavkeICollection;
    }

    public Preduzece getIdpred() {
        return idpred;
    }

    public void setIdpred(Preduzece idpred) {
        this.idpred = idpred;
    }

    public Stranke getIdstr() {
        return idstr;
    }

    public void setIdstr(Stranke idstr) {
        this.idstr = idstr;
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
        if (!(object instanceof FaktureI)) {
            return false;
        }
        FaktureI other = (FaktureI) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FaktureI[ id=" + id + " ]";
    }
    
}
