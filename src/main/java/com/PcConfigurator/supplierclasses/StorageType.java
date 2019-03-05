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

/**
 *
 * @author Jehan & Chethika
 */
@Entity
@Table(name = "storage_type")
public class StorageType extends Parts{

    public StorageType() {
    }

    public StorageType(int id, String name) {
        super(id, name);
    }

    @OneToMany(mappedBy = "storageType", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    
    private List<StorageDrive> storageDrive = new ArrayList();

    public List<StorageDrive> getStorageDrive() {
        return storageDrive;
    }

    public void setStorageDrive(List<StorageDrive> storageDrive) {
        this.storageDrive = storageDrive;
    }
    
    
}
