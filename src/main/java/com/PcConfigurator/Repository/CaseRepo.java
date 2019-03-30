/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.Repository;

import com.PcConfigurator.supplierclasses.Case;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is the Repository interface for the Case Table
 * @author Jehan 
 */
@Repository
public interface CaseRepo extends JpaRepository<Case, Integer>{
    
    public List<Case> findBycaseSize(String name);
}
