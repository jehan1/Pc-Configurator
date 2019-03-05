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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name = "molex_connectors")
public class MolexConnectors {
    @Id
    @Column(name = "no_molex_connectors")
    @NotNull
    private int id;

    public MolexConnectors(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MolexConnectors(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "molexConnectors", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<PowerSupply> powerSupply = new ArrayList();
}
