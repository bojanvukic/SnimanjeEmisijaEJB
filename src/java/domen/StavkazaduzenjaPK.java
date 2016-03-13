/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bojan
 */
@Embeddable
public class StavkazaduzenjaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZaduzenjeID")
    private int zaduzenjeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rb")
    private int rb;

    public StavkazaduzenjaPK() {
    }

    public StavkazaduzenjaPK(int zaduzenjeID, int rb) {
        this.zaduzenjeID = zaduzenjeID;
        this.rb = rb;
    }

    public int getZaduzenjeID() {
        return zaduzenjeID;
    }

    public void setZaduzenjeID(int zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) zaduzenjeID;
        hash += (int) rb;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkazaduzenjaPK)) {
            return false;
        }
        StavkazaduzenjaPK other = (StavkazaduzenjaPK) object;
        if (this.zaduzenjeID != other.zaduzenjeID) {
            return false;
        }
        if (this.rb != other.rb) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.StavkazaduzenjaPK[ zaduzenjeID=" + zaduzenjeID + ", rb=" + rb + " ]";
    }
    
}
