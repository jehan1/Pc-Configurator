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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "video_ports")
public class VideoPorts extends Parts {
    
    @JsonBackReference
    @ManyToMany(mappedBy ="videoPort")
    private List<Monitors> monitors;
    
    public List<Monitors> getMonitors() {
        return monitors;
    }
    
    @JsonBackReference
    @OneToMany(
        mappedBy = "videoPorts",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<GraphicsCardsVideoPorts> gCards = new ArrayList
            <GraphicsCardsVideoPorts>();

    @JsonBackReference
    @OneToMany(
        mappedBy = "motherboard",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<MotherboardVideoPorts> motherboards = new ArrayList
            <MotherboardVideoPorts>();
    
    public VideoPorts() {
    }

    public List<MotherboardVideoPorts> getMotherboards() {
        return motherboards;
    }

    public List<GraphicsCardsVideoPorts> getGraphicsCards() {
        return gCards;
    }

    public void setGraphicsCards(List<GraphicsCardsVideoPorts> graphicsCards) {
        this.gCards = graphicsCards;
    }

    
    public VideoPorts(List<Monitors> monitors, int id, String name) {
        super(id, name);
        this.monitors = monitors;
    }

    public void setMonitors(List<Monitors> monitors) {
        this.monitors = monitors;
    }

    public List<GraphicsCardsVideoPorts> getgCards() {
        return gCards;
    }

    public void setgCards(List<GraphicsCardsVideoPorts> gCards) {
        this.gCards = gCards;
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
