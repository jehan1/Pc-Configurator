/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.RestControllers;

import com.PcConfigurator.Repository.CaseRepo;
import com.PcConfigurator.supplierclasses.Case;
import com.PcConfigurator.supplierclasses.CaseSize;
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
public class CaseRestTest {
    
    @Mock
    private CaseRepo caseRepo;
    
    @InjectMocks
    private CaseRest caseRest;
    
    List  <Case> cse;
    CaseSize st = new CaseSize(1,"ATX");
    CaseSize st1 = new CaseSize(2,"MATX");
    CaseSize st2 = new CaseSize(3,"AAA");
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cse = new ArrayList<>();
        cse.add(new Case(1,"bbb",st));
        cse.add(new Case(2,"www",st1));
        cse.add(new Case(3,"qqq",st2));
        cse.add(new Case(4,"uuu",st));
    }

    /**
     * Test of filteredCase method, of class CaseRest.
     */
    @Test
    public void testFilteredCase() {
        when(caseRepo.findAll()).thenReturn(cse);
        ArrayList <Case> c = (ArrayList <Case>) 
                caseRest.filteredCase("MATX");
       
        Assert.assertTrue(c.size()== 3);
    }
    
}
