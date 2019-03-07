/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.Repository;

import com.PcConfigurator.supplierclasses.Motherboard;
import com.PcConfigurator.supplierclasses.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jehan
 */
@Repository
public interface MotherboardRepo extends JpaRepository<Motherboard, Integer> {
    
}
