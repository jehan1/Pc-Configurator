/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name="processor")
public class Processor extends Parts  {

    public Processor(String speed, int id, String name) {
        super(id, name);
        this.speed = speed;
        
    }
    @NotNull
    private String speed;
    
    //@NotNull
    //private String socket;
    
    @ManyToOne
    @JoinColumn(name="processor_socket_id")
    
    private ProcessorSocket processorSocket;
    
    public Processor(){}

    public ProcessorSocket getProcessorSocket() {
        return processorSocket;
    }

    public void setProcessorSocket(ProcessorSocket processorSocket) {
        this.processorSocket = processorSocket;
    }

   
    
 
    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
 
    @Override
    public String toString() {
        return "Processor{" +
                "id=" + getId() +
                ", title='" + getName() + '\'' +
                ", Speed='" + speed + '\'' + ", Socket='" + processorSocket.getSocket() + '\'' +
                '}';
    }
}
