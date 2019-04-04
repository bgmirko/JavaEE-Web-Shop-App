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
@Table(name = "pdv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pdv.findAll", query = "SELECT p FROM Pdv p"),
    @NamedQuery(name = "Pdv.findById", query = "SELECT p FROM Pdv p WHERE p.id = :id"),
    @NamedQuery(name = "Pdv.findByNaziv", query = "SELECT p FROM Pdv p WHERE p.naziv = :naziv"),
    @NamedQuery(name = "Pdv.findByStopa", query = "SELECT p FROM Pdv p WHERE p.stopa = :stopa")})
public class Pdv implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "stopa")
    private int stopa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpdv")
    private Collection<Artikli> artikliCollection;

    public Pdv() {
    }

    public Pdv(Integer id) {
        this.id = id;
    }

    public Pdv(Integer id, String naziv, int stopa) {
        this.id = id;
        this.naziv = naziv;
        this.stopa = stopa;
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

    public int getStopa() {
        return stopa;
    }

    public void setStopa(int stopa) {
        this.stopa = stopa;
    }

    @XmlTransient
    public Collection<Artikli> getArtikliCollection() {
        return artikliCollection;
    }

    public void setArtikliCollection(Collection<Artikli> artikliCollection) {
        this.artikliCollection = artikliCollection;
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
        if (!(object instanceof Pdv)) {
            return false;
        }
        Pdv other = (Pdv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pdv[ id=" + id + " ]";
    }
    
}
