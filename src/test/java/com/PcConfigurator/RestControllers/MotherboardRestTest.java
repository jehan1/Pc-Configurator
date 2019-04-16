/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.MotherboardRepo;
import com.PcConfigurator.supplierclasses.Motherboard;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class MotherboardRestTest {

    @Mock
    private MotherboardRepo motherboardRepo;
    

    @InjectMocks
    private MotherboardRest motherboardRest;
    
    List  <Motherboard> motherboard;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        motherboard = new ArrayList<>();
        motherboard.add(new Motherboard(1,"aaa"));
        motherboard.add(new Motherboard());
    
    }
    
    @Test
    public void getMotherboards() throws Exception {

        when(motherboardRepo.findAll()).thenReturn(motherboard);
        ArrayList<Motherboard> h = (ArrayList<Motherboard>) motherboardRest.allMotherboards();
       
        assertNotNull(h);
        Assert.assertEquals(2, h.size());
 
     }            
}