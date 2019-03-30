/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;


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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *This is the entity class for the table motherboard_has_pci_lanes
 * @author Jehan
 */
@Entity
@Table(name = "motherboard_has_pci_lanes")
public class MotherboardPciLanes implements Serializable{
    
    @EmbeddedId
    private MotherboardPciLanesId id;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("motherboardId")
    @JoinColumn(name = "motherboard_id")
    private Motherboard motherboard;
 
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pciLaneId")
    @JoinColumn(name = "pci_lanes_id")
    private PciLanes pciLanes;
   
    @Column(name = "quantity")
    private int quantity;

    /**
     * Initialises the Motherboard PCI lane object
     * @param id
     * @param motherboard
     * @param pciLanes
     * @param quantity 
     */
    public MotherboardPciLanes(MotherboardPciLanesId id, 
            Motherboard motherboard, PciLanes pciLanes, int quantity) {
        this.id = id;
        this.motherboard = motherboard;
        this.pciLanes = pciLanes;
        this.quantity = quantity;
    }
 
    /**
     * Empty constructor for the persistence object
     */
    public MotherboardPciLanes() {}

    /**
     * 
     * @return get the  MotherboardPciLanes ID
     */
    public MotherboardPciLanesId getId() {
        return id;
    }

    /**
     * Sets the MotherboardPciLanes ID
     * @param id 
     */
    public void setId(MotherboardPciLanesId id) {
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
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final MotherboardPciLanes other = (MotherboardPciLanes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
