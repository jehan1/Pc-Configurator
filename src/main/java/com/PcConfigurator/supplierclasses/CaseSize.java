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
@Table(name = "case_size")
public class CaseSize {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    @NotNull
    private String size;

    /**
     * 
     * @param id id of the case size
     * @param size name of the case size
     */
    public CaseSize(int id, String size) {
        this.id = id;
        this.size = size;
    }
    
    /**
     * Empty constructor for the persistence interface 
     */
    public CaseSize(){}
    
    @OneToMany(mappedBy = "caseSize", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Case> casename = new ArrayList();
     
    @OneToMany(mappedBy = "caseSize", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Motherboard> motherboard = new ArrayList();
    
    /**
     * 
     * @return the Id of the interface
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the Case size
     * @param id Id of the interface
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return the name of the case size
     */
    public String getSize() {
        return size;
    }

    /**
     * Set the case Size
     * @param size String name of the case size
     */
    public void setSize(String size) {
        this.size = size;
    }
}
