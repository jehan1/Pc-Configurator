/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "memory_type")
public class MemoryType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "memory_type", unique=true)
    @NotNull
    private String memoryType;

    /**
     * Initialise the Memory type object
     * @param id = Unique Id of the memory type
     * @param memoryType 
     */
    public MemoryType(int id, String memoryType) {
        this.id = id;
        this.memoryType = memoryType;
    }

    /**
     * Empty Constructor for the persistence framework
     */
    public MemoryType(){}
    
    @OneToMany(mappedBy = "memoryType", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Memory> memory = new ArrayList();
    
    @OneToMany(mappedBy = "memoryType", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Motherboard> motherboard = new ArrayList();

    /**
     * 
     * @return The Id of the memory type
     */
    public int getId() {
        return id;
    }

    /**
     * Set the memory type Id
     * @param id Memory type Id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @return Memory Type String
     */
    public String getMemoryType() {
        return memoryType;
    }

    /**
     * Sets the the memory type
     * @param memoryType name Of the memory type
     */
    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }
 
}
