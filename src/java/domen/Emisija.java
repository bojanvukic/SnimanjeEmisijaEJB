/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Bojan
 */
@Entity
@Table(name = "emisija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emisija.findAll", query = "SELECT e FROM Emisija e"),
    @NamedQuery(name = "Emisija.findByEmisijaID", query = "SELECT e FROM Emisija e WHERE e.emisijaID = :emisijaID"),
    @NamedQuery(name = "Emisija.findByNazivEmisije", query = "SELECT e FROM Emisija e WHERE e.nazivEmisije = :nazivEmisije"),
    @NamedQuery(name = "Emisija.findByTipEmisije", query = "SELECT e FROM Emisija e WHERE e.tipEmisije = :tipEmisije"),
    @NamedQuery(name = "Emisija.findMaxID", query = "SELECT MAX(e.emisijaID) FROM Emisija e")})
public class Emisija implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmisijaID")
    private Integer emisijaID;
    @Size(max = 40)
    @Column(name = "NazivEmisije")
    private String nazivEmisije;
    @Size(max = 40)
    @Column(name = "TipEmisije")
    private String tipEmisije;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emisijaID")
    private List<Zaduzenje> zaduzenjeList;

    public Emisija() {
    }

    public Emisija(Integer emisijaID) {
        this.emisijaID = emisijaID;
    }

    public Integer getEmisijaID() {
        return emisijaID;
    }

    public void setEmisijaID(Integer emisijaID) {
        this.emisijaID = emisijaID;
    }

    public String getNazivEmisije() {
        return nazivEmisije;
    }

    public void setNazivEmisije(String nazivEmisije) {
        this.nazivEmisije = nazivEmisije;
    }

    public String getTipEmisije() {
        return tipEmisije;
    }

    public void setTipEmisije(String tipEmisije) {
        this.tipEmisije = tipEmisije;
    }

    @XmlTransient
    public List<Zaduzenje> getZaduzenjeList() {
        return zaduzenjeList;
    }

    public void setZaduzenjeList(List<Zaduzenje> zaduzenjeList) {
        this.zaduzenjeList = zaduzenjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emisijaID != null ? emisijaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emisija)) {
            return false;
        }
        Emisija other = (Emisija) object;
        if ((this.emisijaID == null && other.emisijaID != null) || (this.emisijaID != null && !this.emisijaID.equals(other.emisijaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Emisija[ emisijaID=" + emisijaID + " ]";
    }
    
}
