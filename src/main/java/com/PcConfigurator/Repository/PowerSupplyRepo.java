/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.Repository;

import com.PcConfigurator.supplierclasses.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is the Repository interface for the Power Supply Table
 * @author Jehan 
 */
public interface PowerSupplyRepo extends JpaRepository<PowerSupply, Integer>{
    
}
