/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "placanja_i")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlacanjaI.findAll", query = "SELECT p FROM PlacanjaI p"),
    @NamedQuery(name = "PlacanjaI.findById", query = "SELECT p FROM PlacanjaI p WHERE p.id = :id"),
    @NamedQuery(name = "PlacanjaI.findByBrPlacanja", query = "SELECT p FROM PlacanjaI p WHERE p.brPlacanja = :brPlacanja"),
    @NamedQuery(name = "PlacanjaI.findByDatum", query = "SELECT p FROM PlacanjaI p WHERE p.datum = :datum"),
    @NamedQuery(name = "PlacanjaI.findByKomentar", query = "SELECT p FROM PlacanjaI p WHERE p.komentar = :komentar"),
    @NamedQuery(name = "PlacanjaI.findByPlaceno", query = "SELECT p FROM PlacanjaI p WHERE p.placeno = :placeno"),
    @NamedQuery(name = "PlacanjaI.findByLink", query = "SELECT p FROM PlacanjaI p WHERE p.link = :link"),
    @NamedQuery(name = "PlacanjaI.findByUneo", query = "SELECT p FROM PlacanjaI p WHERE p.uneo = :uneo"),
    @NamedQuery(name = "PlacanjaI.findByUneoDatum", query = "SELECT p FROM PlacanjaI p WHERE p.uneoDatum = :uneoDatum"),
    @NamedQuery(name = "PlacanjaI.findByIzmenio", query = "SELECT p FROM PlacanjaI p WHERE p.izmenio = :izmenio"),
    @NamedQuery(name = "PlacanjaI.findByIzmenioDatum", query = "SELECT p FROM PlacanjaI p WHERE p.izmenioDatum = :izmenioDatum"),
    @NamedQuery(name = "PlacanjaI.findByStorno", query = "SELECT p FROM PlacanjaI p WHERE p.storno = :storno")})
public class PlacanjaI implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "BrPlacanja")
    private String brPlacanja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Size(max = 30)
    @Column(name = "Komentar")
    private String komentar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Placeno")
    private double placeno;
    @Column(name = "link")
    private Integer link;
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
    @JoinColumn(name = "idpred", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Preduzece idpred;
    @JoinColumn(name = "idstr", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stranke idstr;

    public PlacanjaI() {
    }

    public PlacanjaI(Integer id) {
        this.id = id;
    }

    public PlacanjaI(Integer id, Date datum, double placeno, String uneo, Date uneoDatum, String storno) {
        this.id = id;
        this.datum = datum;
        this.placeno = placeno;
        this.uneo = uneo;
        this.uneoDatum = uneoDatum;
        this.storno = storno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrPlacanja() {
        return brPlacanja;
    }

    public void setBrPlacanja(String brPlacanja) {
        this.brPlacanja = brPlacanja;
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

    public double getPlaceno() {
        return placeno;
    }

    public void setPlaceno(double placeno) {
        this.placeno = placeno;
    }

    public Integer getLink() {
        return link;
    }

    public void setLink(Integer link) {
        this.link = link;
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
        if (!(object instanceof PlacanjaI)) {
            return false;
        }
        PlacanjaI other = (PlacanjaI) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PlacanjaI[ id=" + id + " ]";
    }
    
}
