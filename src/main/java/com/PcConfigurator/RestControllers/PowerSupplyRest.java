/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import java.util.ArrayList;
import java.util.List;

import com.PcConfigurator.Repository.PowerSupplyRepo;
import com.PcConfigurator.supplierclasses.PowerSupply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the Rest Controller for the power Supply Repository
 * @author Jehan
 */
@RestController
public class PowerSupplyRest {
    
    @Autowired
    PowerSupplyRepo powerSupplyRepository;
    
    /**
     * 
     * @return all the power supplies
     */
    @GetMapping(path="/PowerSupplyAll")
    public @ResponseBody Iterable<PowerSupply> allPowerSupplies(){
        return powerSupplyRepository.findAll();
    }
  
    /**
     * This method filters the Power supply by the no of molex connectors and 
     * the voltage requirement
     * @param sVoltage This is an infinite parameter
     * @param sMolex This is an infinite parameter
     * @return 
     */
    @GetMapping(path="/PowerSupply")
    public @ResponseBody Iterable<PowerSupply> filteredPowerSupplies(
            @RequestParam String sMolex , @RequestParam String sVoltage ){
        
        int voltage = Integer.parseInt(sVoltage);
        int molex = Integer.parseInt(sMolex);
        
        List<PowerSupply> allPpwerSupply = powerSupplyRepository.findAll();
        List<PowerSupply> filteredPowerSupply = new ArrayList<>();
 
        for( PowerSupply temp : allPpwerSupply){
            if(temp.getVoltage() >= voltage + 150 && 
                    temp.getMolexConnectors().getId() > molex){
                filteredPowerSupply.add(temp);
            }
        }
        return filteredPowerSupply;
    }
    
}
