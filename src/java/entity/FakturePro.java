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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "fakture_pro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FakturePro.findAll", query = "SELECT f FROM FakturePro f"),
    @NamedQuery(name = "FakturePro.findById", query = "SELECT f FROM FakturePro f WHERE f.id = :id"),
    @NamedQuery(name = "FakturePro.findByBrFakture", query = "SELECT f FROM FakturePro f WHERE f.brFakture = :brFakture"),
    @NamedQuery(name = "FakturePro.findByDatum", query = "SELECT f FROM FakturePro f WHERE f.datum = :datum"),
    @NamedQuery(name = "FakturePro.findByKomentar", query = "SELECT f FROM FakturePro f WHERE f.komentar = :komentar"),
    @NamedQuery(name = "FakturePro.findByKurs", query = "SELECT f FROM FakturePro f WHERE f.kurs = :kurs"),
    @NamedQuery(name = "FakturePro.findByVrednost", query = "SELECT f FROM FakturePro f WHERE f.vrednost = :vrednost"),
    @NamedQuery(name = "FakturePro.findByUneo", query = "SELECT f FROM FakturePro f WHERE f.uneo = :uneo"),
    @NamedQuery(name = "FakturePro.findByUneoDatum", query = "SELECT f FROM FakturePro f WHERE f.uneoDatum = :uneoDatum"),
    @NamedQuery(name = "FakturePro.findByIzmenio", query = "SELECT f FROM FakturePro f WHERE f.izmenio = :izmenio"),
    @NamedQuery(name = "FakturePro.findByIzmenioDatum", query = "SELECT f FROM FakturePro f WHERE f.izmenioDatum = :izmenioDatum"),
    @NamedQuery(name = "FakturePro.findByStorno", query = "SELECT f FROM FakturePro f WHERE f.storno = :storno"),
    @NamedQuery(name = "FakturePro.findByValuta", query = "SELECT f FROM FakturePro f WHERE f.valuta = :valuta"),
    @NamedQuery(name = "FakturePro.findByFakturisano", query = "SELECT f FROM FakturePro f WHERE f.fakturisano = :fakturisano"),
    @NamedQuery(name = "FakturePro.findByIdmag", query = "SELECT f FROM FakturePro f WHERE f.idmag = :idmag"),
    @NamedQuery(name = "FakturePro.findByValutnavaluta", query = "SELECT f FROM FakturePro f WHERE f.valutnavaluta = :valutnavaluta"),
    @NamedQuery(name = "FakturePro.findByKorisnik", query = "SELECT f FROM FakturePro f WHERE f.korisnik = :korisnik"),
    @NamedQuery(name = "FakturePro.findByNapomenaporez", query = "SELECT f FROM FakturePro f WHERE f.napomenaporez = :napomenaporez"),
    // moj kod
    @NamedQuery(name = "FakturePro.findByStranka", query = "SELECT f FROM FakturePro f WHERE f.idstr = :idstr")})
public class FakturePro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "Kurs") // , columnDefinition="Double default '1'"
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
    @Column(name = "UneoDatum")  //, columnDefinition="DATE DEFAULT 0000-00-00 00:00:00"
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
    @Column(name = "valuta")
    @Temporal(TemporalType.DATE)
    private Date valuta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "fakturisano")
    private String fakturisano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmag")
    private int idmag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "valutnavaluta")
    private String valutnavaluta;
    @Size(max = 45)
    @Column(name = "korisnik")
    private String korisnik;
    @Size(max = 200)
    @Column(name = "napomenaporez")
    private String napomenaporez;
    @JoinColumn(name = "idpred", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Preduzece idpred;
    @JoinColumn(name = "idstr", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stranke idstr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fakturePro")
    private Collection<FakstavkePro> fakstavkeProCollection;

    public FakturePro() {
    }

//    Dobra fora da se pre persist podese default vrednosti ili slicno 
//    @PrePersist
//    protected void onCreate() 
//    {
//     
//    }
//    
    public FakturePro(Integer id) {
        this.id = id;
    }

    public FakturePro(Integer id, Date datum, double kurs, double vrednost, String uneo, Date uneoDatum, String storno, Date valuta, String fakturisano, int idmag, String valutnavaluta) {
        this.id = id;
        this.datum = datum;
        this.kurs = kurs;
        this.vrednost = vrednost;
        this.uneo = uneo;
        this.uneoDatum = uneoDatum;
        this.storno = storno;
        this.valuta = valuta;
        this.fakturisano = fakturisano;
        this.idmag = idmag;
        this.valutnavaluta = valutnavaluta;
        uneo = "uneo";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFakturisano() {
        return fakturisano;
    }

    public void setFakturisano(String fakturisano) {
        this.fakturisano = fakturisano;
    }

    public int getIdmag() {
        return idmag;
    }

    public void setIdmag(int idmag) {
        this.idmag = idmag;
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

    public String getNapomenaporez() {
        return napomenaporez;
    }

    public void setNapomenaporez(String napomenaporez) {
        this.napomenaporez = napomenaporez;
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

    @XmlTransient
    public Collection<FakstavkePro> getFakstavkeProCollection() {
        return fakstavkeProCollection;
    }

    public void setFakstavkeProCollection(Collection<FakstavkePro> fakstavkeProCollection) {
        this.fakstavkeProCollection = fakstavkeProCollection;
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
        if (!(object instanceof FakturePro)) {
            return false;
        }
        FakturePro other = (FakturePro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FakturePro[ id=" + id + " ]";
    }

}
