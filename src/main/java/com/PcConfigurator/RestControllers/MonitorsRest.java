/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.MonitorsRepo;
import com.PcConfigurator.supplierclasses.Monitors;
import com.PcConfigurator.supplierclasses.VideoPorts;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This the Rest controller for the Monitors Repository
 * @author Jehan
 */
@RestController
public class MonitorsRest {
    
    @Autowired
    MonitorsRepo monitorRepository;

    /**
     * 
     * @return All the monitors
     */
    @GetMapping(path="/MonitorsAll")
    public @ResponseBody Iterable<Monitors> allMonitors(){
        return monitorRepository.findAll();
    }
   
    /**
     * This filters the monitors by their video ports
     * @param vPort video port id (unlimited IDs can be entered
     * @return filtered list of monitors
     */
    @GetMapping(path="/Monitors")
    public @ResponseBody Iterable<Monitors> filteredMonitors(
            @RequestParam String ... vPort){
        
        List<Monitors> allMonitors = monitorRepository.findAll();
        List<Monitors> filteredMonitors = new ArrayList<>();
        
        for ( String temp : vPort){
            int id = Integer.parseInt(temp);
      
            for ( Monitors mon : allMonitors ){
                List <VideoPorts> v = mon.getVideoPort();
                for (VideoPorts vp : v){
                    if( vp.getId() == id && !filteredMonitors.contains(mon))
                        filteredMonitors.add(mon);
                }
            }
        }
        return filteredMonitors;
    }
    
    
}
