/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.StorageDriveRepo;
import com.PcConfigurator.supplierclasses.PortsM;
import com.PcConfigurator.supplierclasses.StorageDrive;
import com.PcConfigurator.supplierclasses.StorageType;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Jehan
 */
public class StorageDriveRestTest {

    @Mock
    private StorageDriveRepo storageDriveRepo;
    
    @InjectMocks
    private StorageDriveRest storageRest;
    
    List  <StorageDrive> storageDrive;
    StorageType st = new StorageType(1,"aa");
    PortsM pm = new PortsM(1,"qq");
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        storageDrive = new ArrayList<>();
        storageDrive.add(new StorageDrive(1,"bbb",20,st,null));
        storageDrive.add(new StorageDrive(2,"www",20,st,pm));
    }
 
    /**
     * Test of storageDrives method, of class StorageDriveRest.
     */
    @Test
    public void testStorageDrives() {
        when(storageDriveRepo.findAll()).thenReturn(storageDrive);
        ArrayList <StorageDrive> storage = (ArrayList <StorageDrive>) 
                storageRest.storageDrives();
       
        Assert.assertTrue(storage.size()== 1);
        for(StorageDrive temp : storage){
            Assert.assertEquals(temp.getId(), 1);
        } 
    }

    /**
     * Test of storageDriveMdrive method, of class StorageDriveRest.
     */
    @Test
    public void testStorageDriveMdrive() {
        when(storageDriveRepo.findAll()).thenReturn(storageDrive);
        ArrayList <StorageDrive> storage = (ArrayList <StorageDrive>) 
                storageRest.storageDriveMdrive("1");
        
        Assert.assertTrue(storage.size()== 1);
        for(StorageDrive temp : storage){
            Assert.assertEquals(temp.getId(), 2);
        }
    
    }
}   