/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.GraphicsCardRepo;
import com.PcConfigurator.supplierclasses.GraphicsCard;
import com.PcConfigurator.supplierclasses.MolexConnectors;
import com.PcConfigurator.supplierclasses.PciLanes;
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
public class GraphicsCardRestTest {
   
    
    @Mock
    private GraphicsCardRepo graphicsCardRepo;
    
    @InjectMocks
    private GraphicsCardRest graphicsCardRest;
    
    List <GraphicsCard> gCard;
    PciLanes p1 = new PciLanes(1,"aaa");
    PciLanes p2 = new PciLanes(2,"bbb");
    MolexConnectors m = new MolexConnectors(2);
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        gCard = new ArrayList<>();
        gCard.add(new GraphicsCard(1, "www", "20", p1 , m));
        gCard.add(new GraphicsCard(2, "lll", "20", p2 , m));
    }
    
    /**
     * Test of findByPciLane method, of class GraphicsCardRest.
     */
    @Test
    public void testFindByPciLane() {
        when(graphicsCardRepo.findAll()).thenReturn(gCard);
        ArrayList <GraphicsCard> g = (ArrayList <GraphicsCard>) 
                graphicsCardRest.findByPciLane("1");
       
        Assert.assertTrue(g.size()== 1);
        for(GraphicsCard temp : g){
            Assert.assertEquals(temp.getId(), 1);
        } 
    }
    
}
