/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * This is the entity class for the Video Ports database table
 * @author Jehan 
 */
@Entity
@Table(name = "video_ports")
public class VideoPorts extends Parts {
    
    @JsonBackReference
    @ManyToMany(mappedBy ="videoPort")
    private List<Monitors> monitors;

    @JsonBackReference
    @OneToMany(
        mappedBy = "videoPorts",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<GraphicsCardsVideoPorts> gCards;

    @JsonBackReference
    @OneToMany(
        mappedBy = "motherboard",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<MotherboardVideoPorts> motherboards;
   
    /**
     * Empty constructor for the persistence framework
     */
    public VideoPorts() {}
    
    /**
     * 
     * @param monitors List of monitors 
     * @param id
     * @param name 
     */
    public VideoPorts( int id, String name) {
        super(id, name);
        this.monitors = monitors;
    }

    public List<MotherboardVideoPorts> getMotherboards() {
        return motherboards;
    }

}
