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
 * This class maps the Memory database table
 * @author Jehan 
 */
@Entity
@Table(name = "memory")
public class Memory extends Parts {
    
    @NotNull
    private int capacity;  

    /**
     * Initialise the Memory object
     * @param capacity = Memory capacity
     * @param id = this is inherited from the superclass
     * @param name = name of the memory
     */
    public Memory(int capacity, int id, String name) {
        super(id, name);
        this.capacity = capacity;
    }

    /**
     * Empty Constructor for the persistence framework
     */
    public Memory() {
    }
    
    /**
     * 
     * @return the capacity of the memory
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Set the memory capacity
     * @param capasity = Memory Capacity
     */
    public void setCapacity(int capasity) {
        this.capacity = capasity;
    }
    
    @ManyToOne
    @JoinColumn(name = "memory_type_id")
    private MemoryType memoryType;

    /**
     * 
     * @return Memory Type object
     */
    public MemoryType getMemoryType() {
        return memoryType;
    }

}
