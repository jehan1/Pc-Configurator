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
@Table(name = "storage_drive" )
public class StorageDrive extends Parts {
    
    @NotNull
    private int capasity;
    
    @ManyToOne
    @JoinColumn(name = "storage_type_id")
    
    private StorageType storageType;
    
    @ManyToOne
    @JoinColumn(name = "m.2_ports_id")
    
    private PortsM portsM;

    public StorageDrive() {
        
    }

    public StorageDrive(int capasity, StorageType storageType, PortsM portsM, 
            int id, String name) {
        super(id, name);
        this.capasity = capasity;
        this.storageType = storageType;
        this.portsM = portsM;
    }

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }

    public PortsM getPortsM() {
        return portsM;
    }

    public void setPortsM(PortsM portsM) {
        this.portsM = portsM;
    }
    
    
}
