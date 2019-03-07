/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

    public ProcessorSocket(int id, String socket) {
        this.setId(id);
        this.setSocket(socket);
    }
    
    public ProcessorSocket() {}
    
    @OneToMany(mappedBy = "processorSocket", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Processor> processors = new ArrayList();
    
    @OneToMany(mappedBy = "processorSocket", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Motherboard> motherboard = new ArrayList();

    public int getId() {
        return id;
   }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocket() {
        return socketn;
    }

    public void setSocket(String socket) {
        this.socketn = socket;
    }

    @Override
    public String toString() {
        return "ProcessorSocket{" + "socketn=" + socketn + '}';
    }
    
    
}
