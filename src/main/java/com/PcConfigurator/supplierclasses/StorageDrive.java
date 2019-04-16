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

import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "storage_drive" )
public class StorageDrive extends Parts {
    
    @NotNull
    private int capacity;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "storage_type_id")
    
    private StorageType storageType;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = " m_ports_id ")
    private PortsM portsM;

    /**
     * Empty constructor for the persistence framework
     */
    public StorageDrive() {}

    /**
     * 
     * @param capacity memory capacity of the storage 
     * @param storageType type of the storage
     * @param portsM m.2 port initialising 
     * @param id  inherited from the super class
     * @param name inherited from the super class
     */
    public StorageDrive(int id, String name, int capacity,
            StorageType storageType, PortsM portsM) {
        super(id, name);
        this.capacity = capacity;
        this.storageType = storageType;
        this.portsM = portsM;
    }

    /**
     * 
     * @return the memory capacity of the Storage drive
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the Capacity of the storage drive
     * @param capacity the memory capacity of the Storage drive
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 
     * @return the storage type of the drive
     */
    public StorageType getStorageType() {
        return storageType;
    }

    /**
     * Sets the type of the drive
     * @param storageType type of the drive
     */
    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }

    /**
     * 
     * @return the M.2 port object
     */
    public PortsM getPortsM() {
        return portsM;
    }

    /**
     * Sets the M.2 Port
     * @param portsM m.2 port
     */
    public void setPortsM(PortsM portsM) {
        this.portsM = portsM;
    }
}
