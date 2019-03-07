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
 *
 * @author Jehan
 */
@Embeddable
public class MotherboardPciLanesId implements Serializable{
    
    @Column(name = "motherboard_id")
    private int motherboardId;
    
    @Column(name = "pci_lanes_id")
    private int pciLaneId;

    public MotherboardPciLanesId(int motherboardId, int pciLaneId) {
        this.motherboardId = motherboardId;
        this.pciLaneId = pciLaneId;
    }

    public MotherboardPciLanesId() {}

    public int getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(int motherboardId) {
        this.motherboardId = motherboardId;
    }

    public int getPciLaneId() {
        return pciLaneId;
    }

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
