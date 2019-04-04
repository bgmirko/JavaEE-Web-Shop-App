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
@Table(name = "fakture_u")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaktureU.findAll", query = "SELECT f FROM FaktureU f"),
    @NamedQuery(name = "FaktureU.findById", query = "SELECT f FROM FaktureU f WHERE f.id = :id"),
    @NamedQuery(name = "FaktureU.findByBrOtpremnice", query = "SELECT f FROM FaktureU f WHERE f.brOtpremnice = :brOtpremnice"),
    @NamedQuery(name = "FaktureU.findByBrCalc", query = "SELECT f FROM FaktureU f WHERE f.brCalc = :brCalc"),
    @NamedQuery(name = "FaktureU.findByBrFakture", query = "SELECT f FROM FaktureU f WHERE f.brFakture = :brFakture"),
    @NamedQuery(name = "FaktureU.findByDatum", query = "SELECT f FROM FaktureU f WHERE f.datum = :datum"),
    @NamedQuery(name = "FaktureU.findByKomentar", query = "SELECT f FROM FaktureU f WHERE f.komentar = :komentar"),
    @NamedQuery(name = "FaktureU.findByTroskovi", query = "SELECT f FROM FaktureU f WHERE f.troskovi = :troskovi"),
    @NamedQuery(name = "FaktureU.findByKurs", query = "SELECT f FROM FaktureU f WHERE f.kurs = :kurs"),
    @NamedQuery(name = "FaktureU.findByVrednost", query = "SELECT f FROM FaktureU f WHERE f.vrednost = :vrednost"),
    @NamedQuery(name = "FaktureU.findByUneo", query = "SELECT f FROM FaktureU f WHERE f.uneo = :uneo"),
    @NamedQuery(name = "FaktureU.findByUneoDatum", query = "SELECT f FROM FaktureU f WHERE f.uneoDatum = :uneoDatum"),
    @NamedQuery(name = "FaktureU.findByIzmenio", query = "SELECT f FROM FaktureU f WHERE f.izmenio = :izmenio"),
    @NamedQuery(name = "FaktureU.findByIzmenioDatum", query = "SELECT f FROM FaktureU f WHERE f.izmenioDatum = :izmenioDatum"),
    @NamedQuery(name = "FaktureU.findByStorno", query = "SELECT f FROM FaktureU f WHERE f.storno = :storno"),
    @NamedQuery(name = "FaktureU.findByCalc", query = "SELECT f FROM FaktureU f WHERE f.calc = :calc"),
    @NamedQuery(name = "FaktureU.findByValuta", query = "SELECT f FROM FaktureU f WHERE f.valuta = :valuta"),
    @NamedQuery(name = "FaktureU.findByDatumPrometa", query = "SELECT f FROM FaktureU f WHERE f.datumPrometa = :datumPrometa"),
    @NamedQuery(name = "FaktureU.findByDatumCalc", query = "SELECT f FROM FaktureU f WHERE f.datumCalc = :datumCalc"),
    @NamedQuery(name = "FaktureU.findByIdmag", query = "SELECT f FROM FaktureU f WHERE f.idmag = :idmag")})
public class FaktureU implements Serializable {
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
    @Column(name = "BrCalc")
    private String brCalc;
    @Size(max = 10)
    @Column(name = "BrFakture")
    private String brFakture;
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Size(max = 200)
    @Column(name = "Komentar")
    private String komentar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Troskovi")
    private Double troskovi;
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
    @Size(max = 2)
    @Column(name = "Calc")
    private String calc;
    @Column(name = "Valuta")
    @Temporal(TemporalType.DATE)
    private Date valuta;
    @Column(name = "DatumPrometa")
    @Temporal(TemporalType.DATE)
    private Date datumPrometa;
    @Column(name = "DatumCalc")
    @Temporal(TemporalType.DATE)
    private Date datumCalc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmag")
    private int idmag;
    @JoinColumn(name = "idpred", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Preduzece idpred;
    @JoinColumn(name = "idstr", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stranke idstr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faktureU")
    private Collection<FakstavkeU> fakstavkeUCollection;

    public FaktureU() {
    }

    public FaktureU(Integer id) {
        this.id = id;
    }

    public FaktureU(Integer id, double kurs, double vrednost, String uneo, String storno, int idmag) {
        this.id = id;
        this.kurs = kurs;
        this.vrednost = vrednost;
        this.uneo = uneo;
        this.storno = storno;
        this.idmag = idmag;
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

    public String getBrCalc() {
        return brCalc;
    }

    public void setBrCalc(String brCalc) {
        this.brCalc = brCalc;
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

    public Double getTroskovi() {
        return troskovi;
    }

    public void setTroskovi(Double troskovi) {
        this.troskovi = troskovi;
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

    public String getCalc() {
        return calc;
    }

    public void setCalc(String calc) {
        this.calc = calc;
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

    public Date getDatumCalc() {
        return datumCalc;
    }

    public void setDatumCalc(Date datumCalc) {
        this.datumCalc = datumCalc;
    }

    public int getIdmag() {
        return idmag;
    }

    public void setIdmag(int idmag) {
        this.idmag = idmag;
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
        if (!(object instanceof FaktureU)) {
            return false;
        }
        FaktureU other = (FaktureU) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FaktureU[ id=" + id + " ]";
    }
    
}
