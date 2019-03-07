/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "graphics_cards")
public class GraphicsCard extends Parts {
    
    @NotNull
    String capasity;
    
    @ManyToOne
    @JoinColumn(name = "pci_lanes_id")
    private PciLanes pciLanes;

    @ManyToOne
    @JoinColumn(name = "molex_connectors")
    private MolexConnectors molexConnectors;
    
    public GraphicsCard() { 
    }
    
    @JsonManagedReference
    @OneToMany(
        mappedBy = "graphicsCard",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<GraphicsCardsVideoPorts> videoPorts;

    public GraphicsCard(String capasity, PciLanes pciLanes, int id, String name) {
        super(id, name);
        this.capasity = capasity;
        this.pciLanes = pciLanes; 
    }

    public MolexConnectors getMolexConnectors() {
        return molexConnectors;
    }

    public void setMolexConnectors(MolexConnectors molexConnectors) {
        this.molexConnectors = molexConnectors;
    }
 
    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<GraphicsCardsVideoPorts> getVideoPorts() {
        return videoPorts;
    }

    public void setVideoPorts(List<GraphicsCardsVideoPorts> videoPorts) {
        this.videoPorts = videoPorts;
    }

    public String getCapasity() {
        return capasity;
    }

    public void setCapasity(String capasity) {
        this.capasity = capasity;
    }

    public PciLanes getPciLanes() {
        return pciLanes;
    }

    public void setPciLanes(PciLanes pciLanes) {
        this.pciLanes = pciLanes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.capasity);
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
        if (!Objects.equals(this.capasity, other.capasity)) {
            return false;
        }
        return true;
    }

}
