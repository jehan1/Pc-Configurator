/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.Repository;

import com.PcConfigurator.supplierclasses.Processor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is the Repository interface for the Processor Table
 * @author Jehan 
 */

@Repository
public interface ProcessorRepo extends JpaRepository<Processor, Integer> {

}
