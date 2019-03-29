/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.supplierclasses.StorageDrive;
import java.util.ArrayList;
import java.util.List;

import com.PcConfigurator.Repository.StorageDriveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Rest Controller of the Storage Device class
 * @author Jehan
 */
@RestController
public class StorageDriveRest {
    
    @Autowired
    private StorageDriveRepo storageDriveRepository;
    
    /**
     * 
     * @return all the storage devices list
     */
    @GetMapping(path="/StorageDriveAll")
    public @ResponseBody Iterable<StorageDrive> allStorageDrive(){
        return storageDriveRepository.findAll();
    }
  
    /**
     * 
     * @return the Storage devices excluding M.2 Drives
     */
    @GetMapping(path="/StorageDrive")
    public @ResponseBody Iterable<StorageDrive> storageDrives() {
        List<StorageDrive> allStorage = storageDriveRepository.findAll();
   
        List<StorageDrive> filteredStorage = new ArrayList<StorageDrive>();
        for (StorageDrive temp: allStorage){
            if (temp.getPortsM() == null){
                filteredStorage.add(temp);
            }
        }
        return filteredStorage;
    }
   
    /**
     * 
     * @param mPortId M.2 Port ID
     * @return M>2 ports with the relevant ID
     */
    @GetMapping(path="/StorageDriveMdrive")
    public @ResponseBody Iterable<StorageDrive> storageDriveMdrive(
                @RequestParam String mPortId) {
        List<StorageDrive> allStorage = storageDriveRepository.findAll();
        int id = Integer.parseInt(mPortId);
        
        List<StorageDrive> filteredStorage = new ArrayList<StorageDrive>();
        for (StorageDrive temp: allStorage){
            
            if (temp.getPortsM() == null){}
            else if (temp.getPortsM().getId() == id){
                filteredStorage.add(temp);
            }
        }
        return filteredStorage;
    }
   
    
}
