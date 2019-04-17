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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Jehan
 */
public class MonitorsRestTest {
  
    @Mock
    private MonitorsRepo monitorsRepo;
    
    @InjectMocks
    private MonitorsRest monitorsRest;
    
    List  <Monitors> monitors;
    List  <VideoPorts> vPorts;
    List  <VideoPorts> vPorts1;
   
    
                
        //add(new VideoPorts(1,"aa"));
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vPorts = new ArrayList<>();
        vPorts.add(new VideoPorts(1,"aa"));
        vPorts1.add(new VideoPorts(2,"bb"));
        
        monitors = new ArrayList<>();
        monitors.add(new Monitors(1, "www",vPorts, 20));
        monitors.add(new Monitors(2, "xxx",vPorts1, 20));
        
    }
    
    /**
     * Test of filteredMonitors method, of class MonitorsRest.
     */
    @Test
    public void testFilteredMonitors() {
        when(monitorsRepo.findAll()).thenReturn(monitors);
        ArrayList <Monitors> mon = (ArrayList <Monitors>) 
                monitorsRest.filteredMonitors("1");
       
        Assert.assertTrue(mon.size()== 1);
        for(Monitors temp : mon){
            Assert.assertEquals(temp.getId(), 1);
    }
    } 
}
