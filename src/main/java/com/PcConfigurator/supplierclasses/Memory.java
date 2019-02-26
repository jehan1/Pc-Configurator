/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan & Chethika
 */
@Entity
@Table(name = "memory")
public class Memory extends Parts {
    
    @NotNull
    private int capasity;  

    public Memory(int capasity, int id, String name) {
        super(id, name);
        this.capasity = capasity;
    }

    public Memory() {
    }
    
    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }
    
    @ManyToOne
    @JoinColumn(name = "memory_type_id")
    
    private MemoryType memoryType;

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(MemoryType memoryType) {
        this.memoryType = memoryType;
    }
    
    
    
}
