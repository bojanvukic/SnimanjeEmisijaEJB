/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bojan
 */
@Entity
@Table(name = "zaduzenje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaduzenje.findAll", query = "SELECT z FROM Zaduzenje z"),
    @NamedQuery(name = "Zaduzenje.findByZaduzenjeID", query = "SELECT z FROM Zaduzenje z WHERE z.zaduzenjeID = :zaduzenjeID"),
    @NamedQuery(name = "Zaduzenje.findByDatumZaduzenja", query = "SELECT z FROM Zaduzenje z WHERE z.datumZaduzenja = :datumZaduzenja"),
    @NamedQuery(name = "Zaduzenje.findByDatumRazduzenja", query = "SELECT z FROM Zaduzenje z WHERE z.datumRazduzenja = :datumRazduzenja"),
    @NamedQuery(name = "Zaduzenje.findByVraceno", query = "SELECT z FROM Zaduzenje z WHERE z.vraceno = :vraceno"),
    @NamedQuery(name = "Zaduzenje.findByVracenoIZaposlenID", query = "SELECT z FROM Zaduzenje z WHERE z.zaposlenID = :zaposlenID AND z.vraceno = :vraceno"),
    @NamedQuery(name = "Zaduzenje.findByZaposlenID", query = "SELECT z FROM Zaduzenje z WHERE z.zaposlenID = :zaposlenID"),
    @NamedQuery(name = "Zaduzenje.findMaxID", query = "SELECT MAX(z.zaduzenjeID) FROM Zaduzenje z")})
public class Zaduzenje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZaduzenjeID")
    private Integer zaduzenjeID;
    @Column(name = "DatumZaduzenja")
    @Temporal(TemporalType.DATE)
    private Date datumZaduzenja;
    @Column(name = "DatumRazduzenja")
    @Temporal(TemporalType.DATE)
    private Date datumRazduzenja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vraceno")
    private boolean vraceno;
    @JoinColumn(name = "Zaduzio", referencedColumnName = "PlanerID")
    @ManyToOne(optional = false)
    private Planer zaduzio;
    @JoinColumn(name = "EmisijaID", referencedColumnName = "EmisijaID")
    @ManyToOne(optional = false)
    private Emisija emisijaID;
    @JoinColumn(name = "ZaposlenID", referencedColumnName = "ZaposlenID")
    @ManyToOne(optional = false)
    private Zaposlen zaposlenID;
    @JoinColumn(name = "Razduzio", referencedColumnName = "PlanerID")
    @ManyToOne(optional = false)
    private Planer razduzio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaduzenje")
    private List<Stavkazaduzenja> stavkazaduzenjaList;

    public Zaduzenje() {
    }

    public Zaduzenje(Integer zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }

    public Zaduzenje(Integer zaduzenjeID, boolean vraceno) {
        this.zaduzenjeID = zaduzenjeID;
        this.vraceno = vraceno;
    }

    public Integer getZaduzenjeID() {
        return zaduzenjeID;
    }

    public void setZaduzenjeID(Integer zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }

    public Date getDatumZaduzenja() {
        return datumZaduzenja;
    }

    public void setDatumZaduzenja(Date datumZaduzenja) {
        this.datumZaduzenja = datumZaduzenja;
    }

    public Date getDatumRazduzenja() {
        return datumRazduzenja;
    }

    public void setDatumRazduzenja(Date datumRazduzenja) {
        this.datumRazduzenja = datumRazduzenja;
    }

    public boolean getVraceno() {
        return vraceno;
    }

    public void setVraceno(boolean vraceno) {
        this.vraceno = vraceno;
    }

    public Planer getZaduzio() {
        return zaduzio;
    }

    public void setZaduzio(Planer zaduzio) {
        this.zaduzio = zaduzio;
    }

    public Emisija getEmisijaID() {
        return emisijaID;
    }

    public void setEmisijaID(Emisija emisijaID) {
        this.emisijaID = emisijaID;
    }

    public Zaposlen getZaposlenID() {
        return zaposlenID;
    }

    public void setZaposlenID(Zaposlen zaposlenID) {
        this.zaposlenID = zaposlenID;
    }

    public Planer getRazduzio() {
        return razduzio;
    }

    public void setRazduzio(Planer razduzio) {
        this.razduzio = razduzio;
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
        hash += (zaduzenjeID != null ? zaduzenjeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaduzenje)) {
            return false;
        }
        Zaduzenje other = (Zaduzenje) object;
        if ((this.zaduzenjeID == null && other.zaduzenjeID != null) || (this.zaduzenjeID != null && !this.zaduzenjeID.equals(other.zaduzenjeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Zaduzenje[ zaduzenjeID=" + zaduzenjeID + " ]";
    }
    
}
