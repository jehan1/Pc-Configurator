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

    public Case(int id, String name, CaseSize caseSize) {
        super(id, name);
        this.caseSize = caseSize;
        
    }
    public Case(){}

    @ManyToOne
    @JoinColumn(name = "case_size_id")
    
    private CaseSize caseSize;
    
    public CaseSize getCaseSize() {
        return caseSize;
    }
  
}