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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "artikli_grp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtikliGrp.findAll", query = "SELECT a FROM ArtikliGrp a"),
    @NamedQuery(name = "ArtikliGrp.findById", query = "SELECT a FROM ArtikliGrp a WHERE a.id = :id"),
    @NamedQuery(name = "ArtikliGrp.findByNaziv", query = "SELECT a FROM ArtikliGrp a WHERE a.naziv = :naziv")})

public class ArtikliGrp implements Serializable {
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
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Artikli> artikliCollection;

    public ArtikliGrp() {
    }

    public ArtikliGrp(Integer id) {
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
        if (!(object instanceof ArtikliGrp)) {
            return false;
        }
        ArtikliGrp other = (ArtikliGrp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ArtikliGrp[ id=" + id + " ]";
    }
    
}
