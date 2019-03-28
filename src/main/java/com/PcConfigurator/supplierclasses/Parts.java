/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan 
 */
@MappedSuperclass
public  class Parts {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique=true)
    @NotNull
    private String name;
    
    public Parts(){}
    public Parts( int id, String name){
        this.setId(id);
        this.setName(name);
        
    }
    
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     public String toString() {
        return "Processor{" +
                "id=" + id +
                ", title='" + name + '\'' +
                '}';
     }
}
