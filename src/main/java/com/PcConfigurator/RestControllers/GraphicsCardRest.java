/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import java.util.ArrayList;
import java.util.List;

import com.PcConfigurator.Repository.GraphicsCardRepo;
import com.PcConfigurator.supplierclasses.GraphicsCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jehan
 */
@RestController
public class GraphicsCardRest {
    
    @Autowired
    private GraphicsCardRepo graphicsCardRepository;
    
    @GetMapping(path="/GraphicsCardsAll")
    public @ResponseBody Iterable<GraphicsCard> allGraphicsCards(){
        return graphicsCardRepository.findAll();
    }
    
    @GetMapping(path="/GraphicsCard")
    public @ResponseBody Iterable<GraphicsCard> findByPciLane
            (@RequestParam String PciLaneId) {
        List<GraphicsCard> allGcards = graphicsCardRepository.findAll();
        int Id =  Integer.parseInt(PciLaneId);
        
        List<GraphicsCard> filteredGcards = new ArrayList<GraphicsCard>();
        for (GraphicsCard temp: allGcards){
            if (temp.getPciLanes().getId() == Id){
                filteredGcards.add(temp);
            }
        }
        return filteredGcards;
    }
}
