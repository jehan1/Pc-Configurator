/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This is the entity class for the Monitors database table
 * @author Jehan 
 */
@Entity
@Table(name="monitors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Monitors extends Parts implements Serializable{

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "monitors_has_video_ports", joinColumns = @JoinColumn
                        (name = "monitors_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "video_ports_id",
                    referencedColumnName = "id"))
    private List<VideoPorts> videoPort;
    
    @NotNull
    private int hertz;
 
    /**
     * Empty constructor for the persistence framework
     */
    public Monitors(){}
   
    /**
     * Initialise the video port object
     * @param videoPorts list of video ports 
     * @param hertz hertz value of the monitor
     * @param id inherited from the super class
     * @param name inherited from the superclass
     */
    public Monitors(List<VideoPorts> videoPorts, int hertz, int id, String name) {
        super(id, name);
        this.videoPort = videoPorts;
        this.hertz = hertz;
    }

    /**
     * 
     * @return the hertz value of the monitor  
     */
    public int getHertz() {
        return hertz;
    }

    /**
     * sets the hertz value
     * @param hertz hertz value of the monitor
     */
    public void setHertz(int hertz) {
        this.hertz = hertz;
    }

    /**
     * 
     * @return the set of video ports of the monitor
     */
    public List<VideoPorts> getVideoPort() {
        return videoPort;
    }

  
    
}
