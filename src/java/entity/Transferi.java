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
@Table(name = "transferi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferi.findAll", query = "SELECT t FROM Transferi t"),
    @NamedQuery(name = "Transferi.findById", query = "SELECT t FROM Transferi t WHERE t.id = :id"),
    @NamedQuery(name = "Transferi.findByBrTransfera", query = "SELECT t FROM Transferi t WHERE t.brTransfera = :brTransfera"),
    @NamedQuery(name = "Transferi.findByDatum", query = "SELECT t FROM Transferi t WHERE t.datum = :datum"),
    @NamedQuery(name = "Transferi.findByKomentar", query = "SELECT t FROM Transferi t WHERE t.komentar = :komentar"),
    @NamedQuery(name = "Transferi.findByUneo", query = "SELECT t FROM Transferi t WHERE t.uneo = :uneo"),
    @NamedQuery(name = "Transferi.findByUneoDatum", query = "SELECT t FROM Transferi t WHERE t.uneoDatum = :uneoDatum"),
    @NamedQuery(name = "Transferi.findByIzmenio", query = "SELECT t FROM Transferi t WHERE t.izmenio = :izmenio"),
    @NamedQuery(name = "Transferi.findByIzmenioDatum", query = "SELECT t FROM Transferi t WHERE t.izmenioDatum = :izmenioDatum"),
    @NamedQuery(name = "Transferi.findByStorno", query = "SELECT t FROM Transferi t WHERE t.storno = :storno")})
public class Transferi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "BrTransfera")
    private String brTransfera;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transferi")
    private Collection<Trastavke> trastavkeCollection;
    @JoinColumn(name = "idmag2", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Magacini idmag2;
    @JoinColumn(name = "idpred", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Preduzece idpred;
    @JoinColumn(name = "idmag", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Magacini idmag;

    public Transferi() {
    }

    public Transferi(Integer id) {
        this.id = id;
    }

    public Transferi(Integer id, Date datum, String uneo, Date uneoDatum, String storno) {
        this.id = id;
        this.datum = datum;
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

    public String getBrTransfera() {
        return brTransfera;
    }

    public void setBrTransfera(String brTransfera) {
        this.brTransfera = brTransfera;
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

    @XmlTransient
    public Collection<Trastavke> getTrastavkeCollection() {
        return trastavkeCollection;
    }

    public void setTrastavkeCollection(Collection<Trastavke> trastavkeCollection) {
        this.trastavkeCollection = trastavkeCollection;
    }

    public Magacini getIdmag2() {
        return idmag2;
    }

    public void setIdmag2(Magacini idmag2) {
        this.idmag2 = idmag2;
    }

    public Preduzece getIdpred() {
        return idpred;
    }

    public void setIdpred(Preduzece idpred) {
        this.idpred = idpred;
    }

    public Magacini getIdmag() {
        return idmag;
    }

    public void setIdmag(Magacini idmag) {
        this.idmag = idmag;
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
        if (!(object instanceof Transferi)) {
            return false;
        }
        Transferi other = (Transferi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Transferi[ id=" + id + " ]";
    }
    
}
