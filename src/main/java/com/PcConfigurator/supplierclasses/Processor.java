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
@Table(name="processor")
public class Processor extends Parts  {
    
    public Processor(){}

    public Processor(String speed, int id, String name, ProcessorSocket processorSocket) {
        super(id, name);
        this.speed = speed;
        this.processorSocket = processorSocket;
    }
    @NotNull
    private String speed;
    
    @ManyToOne
    @JoinColumn(name = "processor_socket_id")
    
    private ProcessorSocket processorSocket;
    
    public ProcessorSocket getProcessorSocket() {
       return processorSocket;
    }

    //public void setProcessorSocket(ProcessorSocket processorSocket) {
   //     this.processorSocket = processorSocket;
    //}

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
