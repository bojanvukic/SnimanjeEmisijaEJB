/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bojan
 */
@Entity
@Table(name = "stavkazaduzenja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavkazaduzenja.findAll", query = "SELECT s FROM Stavkazaduzenja s"),
    @NamedQuery(name = "Stavkazaduzenja.findByZaduzenjeID", query = "SELECT s FROM Stavkazaduzenja s WHERE s.stavkazaduzenjaPK.zaduzenjeID = :zaduzenjeID"),
    @NamedQuery(name = "Stavkazaduzenja.findByRb", query = "SELECT s FROM Stavkazaduzenja s WHERE s.stavkazaduzenjaPK.rb = :rb")})
public class Stavkazaduzenja implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkazaduzenjaPK stavkazaduzenjaPK;
    @JoinColumn(name = "OpermaID", referencedColumnName = "OpremaID")
    @ManyToOne(optional = false)
    private Oprema opermaID;
    @JoinColumn(name = "ZaduzenjeID", referencedColumnName = "ZaduzenjeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zaduzenje zaduzenje;

    public Stavkazaduzenja() {
    }

    public Stavkazaduzenja(StavkazaduzenjaPK stavkazaduzenjaPK) {
        this.stavkazaduzenjaPK = stavkazaduzenjaPK;
    }

    public Stavkazaduzenja(int zaduzenjeID, int rb) {
        this.stavkazaduzenjaPK = new StavkazaduzenjaPK(zaduzenjeID, rb);
    }

    public StavkazaduzenjaPK getStavkazaduzenjaPK() {
        return stavkazaduzenjaPK;
    }

    public void setStavkazaduzenjaPK(StavkazaduzenjaPK stavkazaduzenjaPK) {
        this.stavkazaduzenjaPK = stavkazaduzenjaPK;
    }

    public Oprema getOpermaID() {
        return opermaID;
    }

    public void setOpermaID(Oprema opermaID) {
        this.opermaID = opermaID;
    }

    public Zaduzenje getZaduzenje() {
        return zaduzenje;
    }

    public void setZaduzenje(Zaduzenje zaduzenje) {
        this.zaduzenje = zaduzenje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkazaduzenjaPK != null ? stavkazaduzenjaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavkazaduzenja)) {
            return false;
        }
        Stavkazaduzenja other = (Stavkazaduzenja) object;
        if ((this.stavkazaduzenjaPK == null && other.stavkazaduzenjaPK != null) || (this.stavkazaduzenjaPK != null && !this.stavkazaduzenjaPK.equals(other.stavkazaduzenjaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Stavkazaduzenja[ stavkazaduzenjaPK=" + stavkazaduzenjaPK + " ]";
    }
    
}
