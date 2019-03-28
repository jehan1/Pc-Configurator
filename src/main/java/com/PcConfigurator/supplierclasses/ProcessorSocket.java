/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

/**
 *
 * @author Jehan 
 */

@Entity
@Table(name = "processor_socket")
public class ProcessorSocket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique=true)
    @NotNull
    private String socketn;

    /**
     * Initialise the processor Socket
     * @param id = id of the processor socket
     * @param socket = Name of the processor socket
     */
    public ProcessorSocket(int id, String socket) {
        this.setId(id);
        this.setSocket(socket);
    }
    
    /**
     * Empty constructor for the persistence framework
     */
    public ProcessorSocket() {}
  
    @OneToMany(mappedBy = "processorSocket", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Processor> processors = new ArrayList();
    
    @OneToMany(mappedBy = "processorSocket", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Motherboard> motherboard = new ArrayList();

    /**
     * 
     * @return the Id of The processor Socket
     */
    public int getId() {
        return id;
    }

    /**
     * Set the processor Socket Id
     * @param id = Id of the Processor socket
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return the processor Socket name
     */
    public String getSocket() {
        return socketn;
    }

    /**
     * Set the processor Socket name
     * @param socket = Name of the processor socket 
     */
    public void setSocket(String socket) {
        this.socketn = socket;
    }
}
