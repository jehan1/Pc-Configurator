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
 * @author Jehan 
 */
@Entity
@Table(name = "power_supply")
public class PowerSupply extends Parts {
    
   @NotNull
   private int voltage;

   public PowerSupply() {
   }
   
   @ManyToOne
   @JoinColumn(name = "molex_connectors")
   private MolexConnectors molexConnectors;

    public PowerSupply(int voltage, MolexConnectors molexConnectors) {
        this.voltage = voltage;
        this.molexConnectors = molexConnectors;
    }

    public PowerSupply(int voltage, MolexConnectors molexConnectors, int id, String name) {
        super(id, name);
        this.voltage = voltage;
        this.molexConnectors = molexConnectors;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public MolexConnectors getMolexConnectors() {
        return molexConnectors;
    }

    public void setMolexConnectors(MolexConnectors molexConnectors) {
        this.molexConnectors = molexConnectors;
    }
   
   
}
