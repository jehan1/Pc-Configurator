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
@Table(name = "m.2_ports")
public class PortsM extends Parts {
    
    @OneToMany(mappedBy = "portsM", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    
    private List<PortsM> portsM = new ArrayList();

    public PortsM() {
    }

    public PortsM(int id, String name) {
        super(id, name);
    }

    public List<PortsM> getPortsM() {
        return portsM;
    }

    public void setPortsM(List<PortsM> portsM) {
        this.portsM = portsM;
    }
    
    
    
}
