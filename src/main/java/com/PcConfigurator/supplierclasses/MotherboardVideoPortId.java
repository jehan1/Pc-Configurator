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
public class MotherboardVideoPortId implements Serializable{
    
    @Column(name = "motherboard_id")
    private int motherboardId;
    
    @Column(name = "video_ports_id")
    private int videoPortsId;

    public MotherboardVideoPortId(int motherboardCardId, int videoPortsId) {
        this.motherboardId = motherboardCardId;
        this.videoPortsId = videoPortsId;
    }
    
    public MotherboardVideoPortId(){}

    public int getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(int motherboardId) {
        this.motherboardId = motherboardId;
    }

    public int getVideoPortsId() {
        return videoPortsId;
    }

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
