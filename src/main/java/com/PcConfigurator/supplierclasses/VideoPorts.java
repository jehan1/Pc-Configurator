/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "video_ports")
public class VideoPorts extends Parts {
    
    @JsonBackReference
    @ManyToMany(mappedBy ="videoPorts")
    public List<Monitors> monitors;
    
    public List<Monitors> getMonitors() {
        return monitors;
    }

    public VideoPorts() {
    }

    public VideoPorts(List<Monitors> monitors, int id, String name) {
        super(id, name);
        this.monitors = monitors;
    }

    public void setMonitors(List<Monitors> monitors) {
        this.monitors = monitors;
    }

}
