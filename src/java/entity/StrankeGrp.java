/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "stranke_grp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StrankeGrp.findAll", query = "SELECT s FROM StrankeGrp s"),
    @NamedQuery(name = "StrankeGrp.findById", query = "SELECT s FROM StrankeGrp s WHERE s.id = :id"),
    @NamedQuery(name = "StrankeGrp.findByNaziv", query = "SELECT s FROM StrankeGrp s WHERE s.naziv = :naziv")})
public class StrankeGrp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(mappedBy = "idgrp")
    private Collection<Stranke> strankeCollection;

    public StrankeGrp() {
    }

    public StrankeGrp(Integer id) {
        this.id = id;
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

    @XmlTransient
    public Collection<Stranke> getStrankeCollection() {
        return strankeCollection;
    }

    public void setStrankeCollection(Collection<Stranke> strankeCollection) {
        this.strankeCollection = strankeCollection;
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
        if (!(object instanceof StrankeGrp)) {
            return false;
        }
        StrankeGrp other = (StrankeGrp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StrankeGrp[ id=" + id + " ]";
    }
    
}
