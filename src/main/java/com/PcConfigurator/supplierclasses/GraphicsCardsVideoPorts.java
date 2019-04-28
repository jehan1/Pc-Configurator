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
 * This class the the join table class for the Graphics card and the Video Ports
 * many to many relationship 
 * @author Jehan
 */
@Entity
@Table( name = "graphics_cards_has_video_ports")
public class GraphicsCardsVideoPorts implements Serializable  {
    
    @EmbeddedId
    private GraphicsCardsVideoPortsId id;
    
    @Column(name = "quantity")
    private int quantity;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("graphicsCardId")
    @JoinColumn(name = "graphics_cards_id")
    private GraphicsCard graphicsCard;
 
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("videoPortsId")
    @JoinColumn(name = "video_ports_id")
    private VideoPorts videoPorts;

    /**
     * Initialise the graphics cards video ports object
     * @param graphicsCard Graphics Card object
     * @param quantity no of video ports
     */
    public GraphicsCardsVideoPorts( GraphicsCard graphicsCard,
            VideoPorts videoPorts, int quantity) {
        this.graphicsCard = graphicsCard;
        this.quantity = quantity;
        this.videoPorts = videoPorts;
    }

    /**
     * Empty Constructor for the persistence framework
     */
    public GraphicsCardsVideoPorts() {}

    /**
     * 
     * @return the graphics card ID and Video port ID
     */
    public GraphicsCardsVideoPortsId getId() {
        return id;
    }
 
    /**
     * 
     * @return the number of video ports in the graphics card
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the number of video ports in the graphics card
     * @param quantity no of video Ports
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.graphicsCard);
        hash = 83 * hash + Objects.hashCode(this.videoPorts);
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
        final GraphicsCardsVideoPorts other = (GraphicsCardsVideoPorts) obj;
        if (!Objects.equals(this.graphicsCard, other.graphicsCard)) {
            return false;
        }
        if (!Objects.equals(this.videoPorts, other.videoPorts)) {
            return false;
        }
        return true;
    }

}
