/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.CaseRepo;
import com.PcConfigurator.supplierclasses.Case;
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
public class CaseRest {
    
    @Autowired
    private CaseRepo caseRepository;
    
    /**
     * 
     * @return All the case list 
     */
    @GetMapping(path="/CaseAll")
    public @ResponseBody Iterable<Case> allCase(){
        return caseRepository.findAll();
    }
    
    /**
     * This method will return the 
     * @param caseType=Case Size name by query parameter
     * @return filtered list of Cases matching the Case Size name
     */
    @GetMapping(path="/Case")
    public @ResponseBody Iterable<Case> filteredCase(@RequestParam String caseType){
        List<Case> allCases = caseRepository.findAll();
        
        List<Case> filteredCase = new ArrayList<>();
        if(caseType.equals("MATX")){
            for( Case temp : allCases){
                if( temp.getCaseSize().getSize().equals("MATX")){
                    filteredCase.add(temp);
                }
                else if( temp.getCaseSize().getSize().equals("ATX")){
                    filteredCase.add(temp);
                }
            }   
        } 
        else{
            for( Case temp : allCases){
            if( temp.getCaseSize().getSize().equals(caseType)){
               filteredCase.add(temp);
                }   
            }
        }
        return filteredCase;
        
    } 
}
