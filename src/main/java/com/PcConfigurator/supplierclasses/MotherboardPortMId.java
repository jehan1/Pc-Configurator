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
 * This is the composite ID class for the table motherboard_has_m_ports
 * @author Jehan
 */
@Embeddable
public class MotherboardPortMId implements Serializable{
   
    @Column(name = "motherboard_id")
    private int motherboardId;
    
    @Column(name = "m_ports_id")
    private int portMId;

    /**
     * Initialises the object
     * @param motherboardId
     * @param portMId 
     */
    public MotherboardPortMId(int motherboardId, int portMId) {
        this.motherboardId = motherboardId;
        this.portMId = portMId;
    }
  
    /**
     * Empty constructor for the persistence object
     */
    public MotherboardPortMId() {}

    /**
     * get the motherboard ID
     * @return 
     */
    public int getMotherboardId() {
        return motherboardId;
    }

    /**
     * Set the mother board Id
     * @param motherboardId 
     */
    public void setMotherboardId(int motherboardId) {
        this.motherboardId = motherboardId;
    }

    /**
     * 
     * @return the M.2 mort ID
     */
    public int getPortMId() {
        return portMId;
    }

    /**
     * the M.2 mort ID
     * @param portMId 
     */
    public void setPortMId(int portMId) {
        this.portMId = portMId;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.motherboardId;
        hash = 67 * hash + this.portMId;
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
        final MotherboardPortMId other = (MotherboardPortMId) obj;
        if (this.motherboardId != other.motherboardId) {
            return false;
        }
        if (this.portMId != other.portMId) {
            return false;
        }
        return true;
    }

}
