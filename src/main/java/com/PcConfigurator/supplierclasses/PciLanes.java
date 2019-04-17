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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "pci_lanes")
public class PciLanes extends Parts{

    @JsonBackReference
    @OneToMany(mappedBy = "pciLanes", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<GraphicsCard> graphicsCard = new ArrayList();  

    /**
     * Empty constructor for the persistence framework
     */
    public PciLanes() {}

    /**
     * 
     * @param id - id of the  Pci Lanes
     * @param name 0 name of the pci lane (speed)
     */
    public PciLanes(int id, String name) {
        super(id, name);
    }

    /**
     * 
     * @return a  list of graphics cards
     */
    public List<GraphicsCard> getGraphicsCard() {
        return graphicsCard;
    }

    /**
     * Sets the graphics cards
     * @param graphicsCard - list of graphics cards
     */
    public void setGraphicsCard(List<GraphicsCard> graphicsCard) {
        this.graphicsCard = graphicsCard;
    }
  
}
