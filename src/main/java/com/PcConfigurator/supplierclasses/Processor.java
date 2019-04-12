/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;


import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name="processor")
public class Processor extends Parts {
    /**
     * Empty constructor for the persistence framework
     */
    public Processor(){}
    
    /**
     * initialise the processors
     */
    public Processor( int id, String name, String speed,
            ProcessorSocket processorSocket) {
        super(id, name);
        this.speed = speed;
        this.processorSocket = processorSocket;
    }
    
    @NotNull
    private String speed;
    
    @NotNull
    private int voltage;
    
    @ManyToOne
    @JoinColumn(name = "processor_socket_id")
    
    private ProcessorSocket processorSocket;
    
    /**
     * 
     * @return Get processor socket object
     */
    public ProcessorSocket getProcessorSocket() {
       return processorSocket;
    }

    /**
     * 
     * @return The speed of the processor
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the processor
     * @param speed Speed of the processor from the database
     */
     
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     * 
     * @return the voltage required
     */
    public int getVoltage() {
        return voltage;
    }

    /**
     * Sets the required voltage
     * @param voltage 
     */
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    
     
    /**
     * 
     * @return String representation of the processor table
     */
    @Override
    public String toString() {
        return "Processor{" +
                "id=" + getId() +
                ", title='" + getName() + '\'' +
                ", Speed='" + speed + '\'' + ", Socket='" + 
                processorSocket.getSocket() + '\'' +
                '}';
    }
}
