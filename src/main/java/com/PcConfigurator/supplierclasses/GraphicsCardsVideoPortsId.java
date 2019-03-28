/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * This is the ID class for the many to many relationship between graphics card 
 * and the video ports
 * @author Jehan 
 */
@Embeddable
public class GraphicsCardsVideoPortsId implements Serializable{
    
    @Column(name = "graphics_cards_id")
    private int graphicsCardId;
    
    @Column(name = "video_ports_id")
    private int videoPortsId;

    /**
     * Empty constructor for the persistence framework
     */
    public GraphicsCardsVideoPortsId(){}

    /**
     * Initialise the graphics card Id and video port Id
     * @param graphicsCardId 
     * @param videoPortsId 
     */
    public GraphicsCardsVideoPortsId(int graphicsCardId, int videoPortsId) {
        this.graphicsCardId = graphicsCardId;
        this.videoPortsId = videoPortsId;
    }

    /**
     * Set the graphics card id
     * @param graphicsCardId Graphics card id
     */
    public void setGraphicsCardId(int graphicsCardId) {
        this.graphicsCardId = graphicsCardId;
    }

    /**
     * Set the video port Id
     * @param videoPortsId 
     */
    public void setVideoPortsId(int videoPortsId) {
        this.videoPortsId = videoPortsId;
    }
 
    /**
     * 
     * @return the graphics card id
     */
    public int getGraphicsCardId() {
        return graphicsCardId;
    }

    /**
     * 
     * @return the video port id
     */
    public int getVideoPortsId() {
        return videoPortsId;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.graphicsCardId;
        hash = 83 * hash + this.videoPortsId;
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
        final GraphicsCardsVideoPortsId other = (GraphicsCardsVideoPortsId) obj;
        if (this.graphicsCardId != other.graphicsCardId) {
            return false;
        }
        if (this.videoPortsId != other.videoPortsId) {
            return false;
        }
        return true;
    }

}
