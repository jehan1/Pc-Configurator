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
 * This is the composite Id class for the table motherboard_has_video_ports
 * @author Jehan
 */
@Embeddable
public class MotherboardVideoPortId implements Serializable{
    
    @Column(name = "motherboard_id")
    private int motherboardId;
    
    @Column(name = "video_ports_id")
    private int videoPortsId;

    /**
     * Initialises the object
     * @param motherboardCardId
     * @param videoPortsId 
     */
    public MotherboardVideoPortId(int motherboardCardId, int videoPortsId) {
        this.motherboardId = motherboardCardId;
        this.videoPortsId = videoPortsId;
    }
  
    /**
     * Empty Constructor for the persistence framework
     */
    public MotherboardVideoPortId(){}

    /**
     * 
     * @return The motherboard Id
     */
    public int getMotherboardId() {
        return motherboardId;
    }

    /**
     * Set the motherboard Id
     * @param motherboardId 
     */
    public void setMotherboardId(int motherboardId) {
        this.motherboardId = motherboardId;
    }

    /**
     * 
     * @return the video port ID
     */
    public int getVideoPortsId() {
        return videoPortsId;
    }

    /**
     * Set the video port ID
     * @param videoPortsId 
     */
    public void setVideoPortsId(int videoPortsId) {
        this.videoPortsId = videoPortsId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.motherboardId;
        hash = 97 * hash + this.videoPortsId;
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
        final MotherboardVideoPortId other = (MotherboardVideoPortId) obj;
        if (this.motherboardId != other.motherboardId) {
            return false;
        }
        if (this.videoPortsId != other.videoPortsId) {
            return false;
        }
        return true;
    }
 
}
