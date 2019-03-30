/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Jehan
 */
@Entity
@Table(name ="motherboard_has_m_ports")
public class MotherboardPortM implements Serializable{
    
    @EmbeddedId
    private MotherboardPortMId id;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("motherboardId")
    @JoinColumn(name = "motherboard_id")
    private Motherboard motherboard;
 
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("portMId")
    @JoinColumn(name = "m_ports_id")
    private PortsM portM;
   
    @Column(name = "quantity")
    private int quantity;

    public MotherboardPortMId getId() {
        return id;
    }

    public void setId(MotherboardPortMId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MotherboardPortM other = (MotherboardPortM) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
 
}
