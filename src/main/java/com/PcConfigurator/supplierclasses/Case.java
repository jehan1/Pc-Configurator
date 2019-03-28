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

/**
 *
 * @author Jehan
 */
@Entity
@Table(name = "`case`")
public class Case extends Parts {

    /**
     * Initialise the Case
     * @param id inherited from the superclass
     * @param name inherited from the superclass
     * @param caseSize Foreign key from Case size
     */
    public Case(int id, String name, CaseSize caseSize) {
        super(id, name);
        this.caseSize = caseSize;
        
    }
    /**
     * Empty constructor for the persistence interface
     */
    public Case(){}

    @ManyToOne
    @JoinColumn(name = "case_size_id")
    
    private CaseSize caseSize;
    
    /**
     * 
     * @return The case size object
     */
    public CaseSize getCaseSize() {
        return caseSize;
    }
  
}