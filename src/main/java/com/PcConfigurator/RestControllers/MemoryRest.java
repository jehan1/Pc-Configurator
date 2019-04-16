/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;


import com.PcConfigurator.Repository.MemoryRepo;
import com.PcConfigurator.supplierclasses.Memory;
import java.util.ArrayList;
import java.util.List;
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
public class MemoryRest {
    
    @Autowired
    private MemoryRepo memoryRepository;
    
    /**
     * 
     * @return All the Memory list
     */
    @GetMapping(path="/MemoryAll")
    public @ResponseBody Iterable<Memory> allMemory(){
        return memoryRepository.findAll();
    }
    
    /**
     * 
     * @param memTypeId = Id of the memory type
     * @return List of memories filtered using the memory type id
     */
    @GetMapping(path="/Memory")
    public @ResponseBody Iterable<Memory> getMemoryByMemoryType
        (@RequestParam String memTypeId){
        List<Memory> mems = memoryRepository.findAll();
        int id = Integer.parseInt(memTypeId);
        
        List<Memory> memList= new ArrayList<Memory>();
        for( Memory temp : mems ){
            if(temp.getMemoryType().getId() == id ){
                memList.add(temp);
            }  
        }
        return memList;    
    }
    
   
}
