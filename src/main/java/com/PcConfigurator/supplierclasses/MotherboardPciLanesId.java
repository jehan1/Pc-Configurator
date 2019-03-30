/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This the Embedded ID class of the motherboard_has_pci_lanes table
 * @author Jehan
 */
@Embeddable
public class MotherboardPciLanesId implements Serializable{
    
    @Column(name = "motherboard_id")
    private int motherboardId;
    
    @Column(name = "pci_lanes_id")
    private int pciLaneId;

    /**
     * 
     * @param motherboardId ID of the motherboard
     * @param pciLaneId ID of the PCI Lane
     */
    public MotherboardPciLanesId(int motherboardId, int pciLaneId) {
        this.motherboardId = motherboardId;
        this.pciLaneId = pciLaneId;
    }

    /**
     * Empty Constructor for the persistence framework
     */
    public MotherboardPciLanesId() {}

    /**
     * 
     * @return The motherboard ID
     */
    public int getMotherboardId() {
        return motherboardId;
    }

    /**
     * Sets the motherboard Id
     * @param motherboardId 
     */
    public void setMotherboardId(int motherboardId) {
        this.motherboardId = motherboardId;
    }

    /**
     * 
     * @return The PCI lane Id
     */
    public int getPciLaneId() {
        return pciLaneId;
    }

    /**
     * Set the PCI lane Id
     * @param pciLaneId 
     */
    public void setPciLaneId(int pciLaneId) {
        this.pciLaneId = pciLaneId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.motherboardId;
        hash = 29 * hash + this.pciLaneId;
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
        final MotherboardPciLanesId other = (MotherboardPciLanesId) obj;
        if (this.motherboardId != other.motherboardId) {
            return false;
        }
        if (this.pciLaneId != other.pciLaneId) {
            return false;
        }
        return true;
    }
    
    

}
