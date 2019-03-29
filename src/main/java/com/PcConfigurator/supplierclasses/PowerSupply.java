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
 * This is the Entity class for the Power Supplies
 * @author Jehan 
 */
@Entity
@Table(name = "power_supply")
public class PowerSupply extends Parts {
    
    @NotNull
    private int voltage;
   
    @ManyToOne
    @JoinColumn(name = "molex_connectors")
    private MolexConnectors molexConnectors;

    /**
    * Empty constructor for the persistence framework
    */
    public PowerSupply() {}
 
    /**
     * Initialise the power supply object
     * @param voltage Voltage of the power supply
     * @param molexConnectors No of molex connectors the Power supply contain
     * @param id Inherited from the super class
     * @param name Inherited from the super class
     */
    public PowerSupply(int voltage, MolexConnectors molexConnectors, int id, String name) {
        super(id, name);
        this.voltage = voltage;
        this.molexConnectors = molexConnectors;
    }

    /**
     * 
     * @return the voltage of the power supply
     */
    public int getVoltage() {
        return voltage;
    }

    /**
     * Sets the power supply voltage
     * @param voltage voltage of the power supply
     */
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    /**
     * 
     * @return the number of molex connectors in the power supply
     */
    public MolexConnectors getMolexConnectors() {
        return molexConnectors;
    }

    /**
     * Sets the no of molex connectors
     * @param molexConnectors no of molex connectors
     */
    public void setMolexConnectors(MolexConnectors molexConnectors) {
        this.molexConnectors = molexConnectors;
    }
   
   
}
