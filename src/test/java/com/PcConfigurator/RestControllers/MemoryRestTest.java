/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.MemoryRepo;
import com.PcConfigurator.supplierclasses.Memory;
import com.PcConfigurator.supplierclasses.MemoryType;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
public class MemoryRestTest {
    
    @Mock
    private MemoryRepo memoryRepo;
    
    @InjectMocks
    private MemoryRest memoryRest;
    
    List  <Memory> memory;
    MemoryType st = new MemoryType(1,"aa");
    MemoryType st1 = new MemoryType(2,"bb");
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        memory = new ArrayList<>();
        memory.add(new Memory(1,"bbb",20,st));
        memory.add(new Memory(2,"qqq",20,st1));
        
    }

    /**
     * Test of getMemoryByMemoryType method, of class MemoryRest.
     */
    @Test
    public void testGetMemoryByMemoryType() {
       when(memoryRepo.findAll()).thenReturn(memory);
        ArrayList <Memory> mem = (ArrayList <Memory>) 
                memoryRest.getMemoryByMemoryType("1");
       
        Assert.assertTrue(mem.size()== 1);
        for(Memory temp : mem){
            Assert.assertEquals(temp.getId(), 1);
        } 
    }
    
}
