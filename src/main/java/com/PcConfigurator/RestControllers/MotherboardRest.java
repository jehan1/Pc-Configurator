/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.MotherboardRepo;
import com.PcConfigurator.supplierclasses.Motherboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jehan
 */
@RestController
public class MotherboardRest {
    
   @Autowired
   MotherboardRepo motherboardRepository;
   
    @GetMapping(path="/Motherboard")
    public @ResponseBody Iterable<Motherboard> allMotherboards(){
        return motherboardRepository.findAll();
    }
    
}
