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
@Table(name = "oprema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oprema.findAll", query = "SELECT o FROM Oprema o"),
    @NamedQuery(name = "Oprema.findByOpremaID", query = "SELECT o FROM Oprema o WHERE o.opremaID = :opremaID"),
    @NamedQuery(name = "Oprema.findByNazivOpreme", query = "SELECT o FROM Oprema o WHERE o.nazivOpreme = :nazivOpreme"),
    @NamedQuery(name = "Oprema.findByTipOpreme", query = "SELECT o FROM Oprema o WHERE o.tipOpreme = :tipOpreme")})
public class Oprema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OpremaID")
    private Integer opremaID;
    @Size(max = 40)
    @Column(name = "NazivOpreme")
    private String nazivOpreme;
    @Size(max = 40)
    @Column(name = "TipOpreme")
    private String tipOpreme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opermaID")
    private List<Stavkazaduzenja> stavkazaduzenjaList;

    public Oprema() {
    }

    public Oprema(Integer opremaID) {
        this.opremaID = opremaID;
    }

    public Integer getOpremaID() {
        return opremaID;
    }

    public void setOpremaID(Integer opremaID) {
        this.opremaID = opremaID;
    }

    public String getNazivOpreme() {
        return nazivOpreme;
    }

    public void setNazivOpreme(String nazivOpreme) {
        this.nazivOpreme = nazivOpreme;
    }

    public String getTipOpreme() {
        return tipOpreme;
    }

    public void setTipOpreme(String tipOpreme) {
        this.tipOpreme = tipOpreme;
    }

    @XmlTransient
    public List<Stavkazaduzenja> getStavkazaduzenjaList() {
        return stavkazaduzenjaList;
    }

    public void setStavkazaduzenjaList(List<Stavkazaduzenja> stavkazaduzenjaList) {
        this.stavkazaduzenjaList = stavkazaduzenjaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opremaID != null ? opremaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oprema)) {
            return false;
        }
        Oprema other = (Oprema) object;
        if ((this.opremaID == null && other.opremaID != null) || (this.opremaID != null && !this.opremaID.equals(other.opremaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Oprema[ opremaID=" + opremaID + " ]";
    }
    
}
