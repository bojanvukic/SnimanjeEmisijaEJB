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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bojan
 */
@Entity
@Table(name = "zaposlen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposlen.findAll", query = "SELECT z FROM Zaposlen z"),
    @NamedQuery(name = "Zaposlen.findByZaposlenID", query = "SELECT z FROM Zaposlen z WHERE z.zaposlenID = :zaposlenID"),
    @NamedQuery(name = "Zaposlen.findByIme", query = "SELECT z FROM Zaposlen z WHERE z.ime = :ime"),
    @NamedQuery(name = "Zaposlen.findByPrezime", query = "SELECT z FROM Zaposlen z WHERE z.prezime = :prezime"),
    @NamedQuery(name = "Zaposlen.findByJmbg", query = "SELECT z FROM Zaposlen z WHERE z.jmbg = :jmbg"),
    @NamedQuery(name = "Zaposlen.findByDatumZaposlenja", query = "SELECT z FROM Zaposlen z WHERE z.datumZaposlenja = :datumZaposlenja"),
    @NamedQuery(name = "Zaposlen.findByTelefon", query = "SELECT z FROM Zaposlen z WHERE z.telefon = :telefon"),
    @NamedQuery(name = "Zaposlen.findByAdresa", query = "SELECT z FROM Zaposlen z WHERE z.adresa = :adresa"),
    @NamedQuery(name = "Zaposlen.findMaxID", query = "SELECT MAX(z.zaposlenID) FROM Zaposlen z")})
public class Zaposlen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZaposlenID")
    private Integer zaposlenID;
    @Size(max = 40)
    @Column(name = "Ime")
    private String ime;
    @Size(max = 40)
    @Column(name = "Prezime")
    private String prezime;
    @Size(max = 13)
    @Column(name = "JMBG")
    private String jmbg;
    @Column(name = "DatumZaposlenja")
    @Temporal(TemporalType.DATE)
    private Date datumZaposlenja;
    @Size(max = 20)
    @Column(name = "Telefon")
    private String telefon;
    @Size(max = 40)
    @Column(name = "Adresa")
    private String adresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposlenID")
    private List<Zaduzenje> zaduzenjeList;
    @JoinColumn(name = "Ptt", referencedColumnName = "Ptt")
    @ManyToOne(optional = false)
    private Mesto ptt;

    public Zaposlen() {
    }

    public Zaposlen(Integer zaposlenID) {
        this.zaposlenID = zaposlenID;
    }

    public Integer getZaposlenID() {
        return zaposlenID;
    }

    public void setZaposlenID(Integer zaposlenID) {
        this.zaposlenID = zaposlenID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @XmlTransient
    public List<Zaduzenje> getZaduzenjeList() {
        return zaduzenjeList;
    }

    public void setZaduzenjeList(List<Zaduzenje> zaduzenjeList) {
        this.zaduzenjeList = zaduzenjeList;
    }

    public Mesto getPtt() {
        return ptt;
    }

    public void setPtt(Mesto ptt) {
        this.ptt = ptt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zaposlenID != null ? zaposlenID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposlen)) {
            return false;
        }
        Zaposlen other = (Zaposlen) object;
        if ((this.zaposlenID == null && other.zaposlenID != null) || (this.zaposlenID != null && !this.zaposlenID.equals(other.zaposlenID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Zaposlen[ zaposlenID=" + zaposlenID + " ]";
    }
    
}
