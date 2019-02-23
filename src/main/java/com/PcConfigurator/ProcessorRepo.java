/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator;

import com.PcConfigurator.supplierclasses.Processor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jehan & Chethika
 */

@Repository
public interface ProcessorRepo extends JpaRepository<Processor, Integer> {
    
    List<Processor> findByNameContaining(String text);
}
