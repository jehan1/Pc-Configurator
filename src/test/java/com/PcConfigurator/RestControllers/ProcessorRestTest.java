/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.ProcessorRepo;
import com.PcConfigurator.supplierclasses.Processor;
import com.PcConfigurator.supplierclasses.ProcessorSocket;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;
/**
 *
 * @author Jehan
 */
public class ProcessorRestTest {
  
    @Mock
    private ProcessorRepo processorRepo;
    

    @InjectMocks
    private ProcessorRest processorRest;
    
    List  <Processor> processors;
    
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ProcessorSocket ps = new ProcessorSocket(1,"aa");
        ProcessorSocket ps1 = new ProcessorSocket(2,"bb");
        processors = new ArrayList<>();
        processors.add(new Processor(1, "ppp", "ww",
            ps));
        processors.add(new Processor(2, "qqq", "xx",
            ps1));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findBySocket method, of class ProcessorRest.
     */
    @Test
    public void testFindBySocket() {
        when(processorRepo.findAll()).thenReturn(processors);
        ArrayList<Processor> p = (ArrayList<Processor>) processorRest.
                findBySocket("1");
        
        Assert.notNull(p);
        Assert.isTrue(p.size()== 1);
    }

  
    
}
