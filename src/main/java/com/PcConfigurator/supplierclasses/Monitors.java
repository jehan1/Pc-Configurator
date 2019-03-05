/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name="monitors")
public class Monitors extends Parts {

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "monitors_has_video_ports", joinColumns = @JoinColumn
                        (name = "monitors_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "video_ports_id",
                    referencedColumnName = "id"))
    public List<VideoPorts> videoPorts;
    
    @NotNull
    private int hertz;
    
    public List<VideoPorts> getVideoPorts() {
        return videoPorts;
    }

    public Monitors(){}
    
    public Monitors(List<VideoPorts> videoPorts, int hertz, int id, String name) {
        super(id, name);
        this.videoPorts = videoPorts;
        this.hertz = hertz;
    }
 
    public void setVideoPorts(List<VideoPorts> videoPorts) {
        this.videoPorts = videoPorts;
    }
 
    
    public int getHertz() {
        return hertz;
    }

    public void setHertz(int hertz) {
        this.hertz = hertz;
    }
  
}
