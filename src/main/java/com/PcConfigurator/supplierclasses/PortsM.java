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
@Table(name = "m_ports")
public class PortsM extends Parts {
    
    @JsonBackReference
    @OneToMany(mappedBy = "portsM", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<StorageDrive> storageDrive = new ArrayList();

    /**
     * Empty Constructor for the persistence framework
     */
    public PortsM() {
    }

    /**
     * Initialise the m.2 port
     * @param id Inherited from the super class
     * @param name id Inherited from the super class
     */
    public PortsM(int id, String name) {
        super(id, name);
    }

    /**
     * 
     * @return the Storage device list assign to the port
     */
    public List<StorageDrive> getStorageDrive() {
        return storageDrive;
    }
}
