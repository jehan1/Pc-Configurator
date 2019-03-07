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
 *
 * @author Jehan 
 */
@Embeddable
public class GraphicsCardsVideoPortsId implements Serializable{
    
    @Column(name = "graphics_cards_id")
    private int graphicsCardId;
    
    @Column(name = "video_ports_id")
    private int videoPortsId;

    public void setGraphicsCardId(int graphicsCardId) {
        this.graphicsCardId = graphicsCardId;
    }

    public void setVideoPortsId(int videoPortsId) {
        this.videoPortsId = videoPortsId;
    }
   
    public GraphicsCardsVideoPortsId(){}

    public GraphicsCardsVideoPortsId(int graphicsCardId, int videoPortsId) {
        this.graphicsCardId = graphicsCardId;
        this.videoPortsId = videoPortsId;
    }

    public int getGraphicsCardId() {
        return graphicsCardId;
    }

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
