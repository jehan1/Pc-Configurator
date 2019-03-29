/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 *
 * @author Jehan
 */
@Entity
@Table(name = "storage_type")
public class StorageType extends Parts{

    /**
     * Empty constructor for the persistence framework
     */
    public StorageType() { }

    /**
     * Initialise the port type
     * @param id inherited from the superclass
     * @param name inherited from the superclass
     */
    public StorageType(int id, String name) {
        super(id, name);
    }

    @JsonBackReference
    @OneToMany(mappedBy = "storageType", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<StorageDrive> storageDrive = new ArrayList();

    /**
     * 
     * @return the list of storage drives of the storage type
     */
    public List<StorageDrive> getStorageDrive() {
        return storageDrive;
    }

    /**
     * Sets the storage type
     * @param storageDrive type of storage
     */
    public void setStorageDrive(List<StorageDrive> storageDrive) {
        this.storageDrive = storageDrive;
    }
    
    
}
