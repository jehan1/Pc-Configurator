/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "m_ports")
public class PortsM extends Parts {
    
    @JsonBackReference
    @OneToMany(mappedBy = "portsM", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    
    private List<StorageDrive> storageDrive = new ArrayList();

    public PortsM() {
    }

    public PortsM(int id, String name) {
        super(id, name);
    }

    public List<StorageDrive> getStorageDrive() {
        return storageDrive;
    }

    public void setPortsM(List<StorageDrive> storageDrive) {
        this.storageDrive = storageDrive;
    }
    
    
    
}
