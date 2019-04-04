/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mirko
 */
@Entity
@Table(name = "trastavke")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trastavke.findAll", query = "SELECT t FROM Trastavke t"),
    @NamedQuery(name = "Trastavke.findByIdfak", query = "SELECT t FROM Trastavke t WHERE t.trastavkePK.idfak = :idfak"),
    @NamedQuery(name = "Trastavke.findByIdart", query = "SELECT t FROM Trastavke t WHERE t.trastavkePK.idart = :idart"),
    @NamedQuery(name = "Trastavke.findByKolicina", query = "SELECT t FROM Trastavke t WHERE t.kolicina = :kolicina"),
    @NamedQuery(name = "Trastavke.findByCena", query = "SELECT t FROM Trastavke t WHERE t.cena = :cena")})
public class Trastavke implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrastavkePK trastavkePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Kolicina")
    private double kolicina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private double cena;
    @JoinColumn(name = "idart", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikli artikli;
    @JoinColumn(name = "idfak", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transferi transferi;

    public Trastavke() {
    }

    public Trastavke(TrastavkePK trastavkePK) {
        this.trastavkePK = trastavkePK;
    }

    public Trastavke(TrastavkePK trastavkePK, double kolicina, double cena) {
        this.trastavkePK = trastavkePK;
        this.kolicina = kolicina;
        this.cena = cena;
    }

    public Trastavke(int idfak, int idart) {
        this.trastavkePK = new TrastavkePK(idfak, idart);
    }

    public TrastavkePK getTrastavkePK() {
        return trastavkePK;
    }

    public void setTrastavkePK(TrastavkePK trastavkePK) {
        this.trastavkePK = trastavkePK;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Artikli getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
    }

    public Transferi getTransferi() {
        return transferi;
    }

    public void setTransferi(Transferi transferi) {
        this.transferi = transferi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trastavkePK != null ? trastavkePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trastavke)) {
            return false;
        }
        Trastavke other = (Trastavke) object;
        if ((this.trastavkePK == null && other.trastavkePK != null) || (this.trastavkePK != null && !this.trastavkePK.equals(other.trastavkePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Trastavke[ trastavkePK=" + trastavkePK + " ]";
    }
    
}
