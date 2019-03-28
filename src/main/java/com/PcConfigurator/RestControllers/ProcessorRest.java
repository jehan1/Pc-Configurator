/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.Exceptions.PostException;
import java.util.List;
import java.util.ArrayList;

import com.PcConfigurator.Repository.ProcessorRepo;
import com.PcConfigurator.supplierclasses.Processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jehan
 */
@RestController
public class ProcessorRest{
    
    @Autowired
    ProcessorRepo processorRepository;
    
    /**
     * 
     * @return All the processor list
     */
    @GetMapping(path="/ProcessorAll")
    public @ResponseBody Iterable<Processor> findAll(){
        return processorRepository.findAll();
    }
    /**
     * 
     * @param socketId = Processor Socket id
     * @return Processor list with the matching  processorSocketId 
     */
 
    @GetMapping(path="/Processor")
    public @ResponseBody Iterable<Processor> findBySocket
            (@RequestParam String socketId) {
        List<Processor> allProcs = processorRepository.findAll();
        int Id =  Integer.parseInt(socketId);
        
        List<Processor> filteredProcs = new ArrayList<Processor>();
        for (Processor proc: allProcs){
            if (proc.getProcessorSocket().getId() == Id){
                filteredProcs.add(proc);
            }
        }
        return filteredProcs;
    }

    @PostMapping(path="/Processor")
    public @ResponseBody Processor createProcessor(
           @RequestBody Processor newProcessor){
        
        return processorRepository.save(newProcessor);
        
    }
     
}

