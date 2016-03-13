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
@Table(name = "planer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planer.findAll", query = "SELECT p FROM Planer p"),
    @NamedQuery(name = "Planer.findByPlanerID", query = "SELECT p FROM Planer p WHERE p.planerID = :planerID"),
    @NamedQuery(name = "Planer.findByIme", query = "SELECT p FROM Planer p WHERE p.ime = :ime"),
    @NamedQuery(name = "Planer.findByPrezime", query = "SELECT p FROM Planer p WHERE p.prezime = :prezime"),
    @NamedQuery(name = "Planer.findByKorisnickoIme", query = "SELECT p FROM Planer p WHERE p.korisnickoIme = :korisnickoIme"),
    @NamedQuery(name = "Planer.findByKorisnickaSifra", query = "SELECT p FROM Planer p WHERE p.korisnickaSifra = :korisnickaSifra"),
    @NamedQuery(name = "Planer.findByKorisnickoImeISifra", query = "SELECT p FROM Planer p WHERE p.korisnickoIme = :korisnickoIme AND p.korisnickaSifra = :korisnickaSifra")})
public class Planer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PlanerID")
    private Integer planerID;
    @Size(max = 40)
    @Column(name = "Ime")
    private String ime;
    @Size(max = 40)
    @Column(name = "Prezime")
    private String prezime;
    @Size(max = 20)
    @Column(name = "KorisnickoIme")
    private String korisnickoIme;
    @Size(max = 20)
    @Column(name = "KorisnickaSifra")
    private String korisnickaSifra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaduzio")
    private List<Zaduzenje> zaduzenjeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "razduzio")
    private List<Zaduzenje> zaduzenjeList1;

    public Planer() {
    }

    public Planer(Integer planerID) {
        this.planerID = planerID;
    }

    public Integer getPlanerID() {
        return planerID;
    }

    public void setPlanerID(Integer planerID) {
        this.planerID = planerID;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    @XmlTransient
    public List<Zaduzenje> getZaduzenjeList() {
        return zaduzenjeList;
    }

    public void setZaduzenjeList(List<Zaduzenje> zaduzenjeList) {
        this.zaduzenjeList = zaduzenjeList;
    }

    @XmlTransient
    public List<Zaduzenje> getZaduzenjeList1() {
        return zaduzenjeList1;
    }

    public void setZaduzenjeList1(List<Zaduzenje> zaduzenjeList1) {
        this.zaduzenjeList1 = zaduzenjeList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planerID != null ? planerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planer)) {
            return false;
        }
        Planer other = (Planer) object;
        if ((this.planerID == null && other.planerID != null) || (this.planerID != null && !this.planerID.equals(other.planerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Planer[ planerID=" + planerID + " ]";
    }
    
}
