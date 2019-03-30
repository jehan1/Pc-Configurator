/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.Repository;

import com.PcConfigurator.supplierclasses.GraphicsCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  This is the Repository interface for the Graphics card Table
 * @author Jehan
 */
@Repository
public interface GraphicsCardRepo extends JpaRepository<GraphicsCard, Integer>{
    
    
}
