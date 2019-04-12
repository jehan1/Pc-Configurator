/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;


import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "graphics_cards")
public class GraphicsCard extends Parts {
    
    @NotNull
    String capacity;
    
    @NotNull
    String voltage;
    
    @ManyToOne
    @JoinColumn(name = "pci_lanes_id")
    private PciLanes pciLanes;

    @ManyToOne
    @JoinColumn(name = "molex_connectors")
    private MolexConnectors molexConnectors;
    /**
     * Empty Constructor for the persistence framework
     */
    public GraphicsCard() { }
    
    /**
     * Initialise the Graphics card objects
     * @param capacity Capacity of the graphics card
     * @param pciLanes Card's PCI Lane
     * @param id Inherited from the super class
     * @param name Inherited from the super class
     */
    public GraphicsCard(String capacity, PciLanes pciLanes,
            MolexConnectors molexConnectors, int id, String name) {
        super(id, name);
        this.capacity = capacity;
        this.pciLanes = pciLanes; 
        this.molexConnectors = molexConnectors;
    }
    
    @JsonManagedReference
    @OneToMany(
        mappedBy = "graphicsCard",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<GraphicsCardsVideoPorts> videoPorts;

    /**
     * 
     * @return Get the no of Molex connectors the card has
     */
    public MolexConnectors getMolexConnectors() {
        return molexConnectors;
    }

    /**
     * Set the number of Molex connectors
     * @param molexConnectors number of Molex connectors
     */
    public void setMolexConnectors(MolexConnectors molexConnectors) {
        this.molexConnectors = molexConnectors;
    }

    /**
     * 
     * @return Return the video ports
     */
    public List<GraphicsCardsVideoPorts> getVideoPorts() {
        return videoPorts;
    }

    /**
     * Set the video ports
     * @param videoPorts Types of video ports the graphics card has
     */
    public void setVideoPorts(List<GraphicsCardsVideoPorts> videoPorts) {
        this.videoPorts = videoPorts;
    }

    /**
     * 
     * @return Get the capacity of the graphics card
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * Set he graphics cards capacity
     * @param capacity capacity of the graphics card
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * 
     * @return Get the PCI Lane of the card
     */
    public PciLanes getPciLanes() {
        return pciLanes;
    }

    /**
     * Set the PCI Lane type
     * @param pciLanes PCI Lane type
     */
    public void setPciLanes(PciLanes pciLanes) {
        this.pciLanes = pciLanes;
    }

    /**
     * 
     * @return the voltage required 
     */
    public String getVoltage() {
        return voltage;
    }

    /**
     * Sets the required voltage
     * @param voltage 
     */
    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.capacity);
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
        final GraphicsCard other = (GraphicsCard) obj;
        if (!Objects.equals(this.capacity, other.capacity)) {
            return false;
        }
        return true;
    }

}
