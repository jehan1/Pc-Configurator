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
 * @author Jehan & Chethika
 */
@Entity
@Table(name = "pci_lanes")
public class PciLanes extends Parts{

    public PciLanes() {
    }

    public PciLanes(int id, String name) {
        super(id, name);
    }
                                                                                                                                                               
    @JsonBackReference
    @OneToMany(mappedBy = "pciLanes", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    
    private List<GraphicsCard> graphicsCard = new ArrayList();  

    public List<GraphicsCard> getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(List<GraphicsCard> graphicsCard) {
        this.graphicsCard = graphicsCard;
    }
  
}
