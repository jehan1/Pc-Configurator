/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

/**
 *
 * @author Jehan
 */
@Entity
@Table( name = "graphics_cards_has_video_ports")
public class GraphicsCardsVideoPorts implements Serializable  {
    
    @EmbeddedId
    private GraphicsCardsVideoPortsId id;
    
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
   
    @Column(name = "quantity")
    private int quantity;

    public GraphicsCardsVideoPorts( GraphicsCard graphicsCard, 
             int quantity) {
        this.graphicsCard = graphicsCard;
        this.quantity = quantity;
    }

    public GraphicsCardsVideoPorts() {}

    public GraphicsCardsVideoPortsId getId() {
        return id;
    }

    public void setId(GraphicsCardsVideoPortsId id) {
        this.id = id;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public VideoPorts getVideoPorts() {
        return videoPorts;
    }

    public void setVideoPorts(VideoPorts videoPorts) {
        this.videoPorts = videoPorts;
    }

    public int getQuantity() {
        return quantity;
    }

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
