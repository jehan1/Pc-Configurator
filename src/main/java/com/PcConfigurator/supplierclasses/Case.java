/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan & Chethika
 */
@Entity
@Table(name = "case")
public class Case extends Parts {

    private enum Size{ ATX, MICRO_ATX , ITX, THIN_MINI_ITX}
    @NotNull
    Size size;
    public Case(int id, String name, Size size ) {
        super(id, name);
        this.size=size;
    }
    public Case(){}

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    
    
 
}