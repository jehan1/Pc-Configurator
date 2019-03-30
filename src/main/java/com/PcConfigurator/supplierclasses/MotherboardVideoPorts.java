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
 *
 * @author Jehan
 */
@Entity
@Table( name = "motherboard_has_video_ports")
public class MotherboardVideoPorts implements Serializable {
    
    @EmbeddedId
    private MotherboardVideoPortId id;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("motherboardId")
    @JoinColumn(name = "motherboard_id")
    private Motherboard motherboard;
 
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("videoPortsId")
    @JoinColumn(name = "video_ports_id")
    private VideoPorts videoPorts;
   
    @Column(name = "quantity")
    private int quantity;

    public MotherboardVideoPorts(MotherboardVideoPortId id,
            Motherboard motherboard, VideoPorts videoPorts, int quantity) {
        this.id = id;
        this.motherboard = motherboard;
        this.videoPorts = videoPorts;
        this.quantity = quantity;
    }

    public MotherboardVideoPorts() {}

    public MotherboardVideoPortId getId() {
        return id;
    }

    public void setId(MotherboardVideoPortId id) {
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
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + this.quantity;
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
        final MotherboardVideoPorts other = (MotherboardVideoPorts) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
