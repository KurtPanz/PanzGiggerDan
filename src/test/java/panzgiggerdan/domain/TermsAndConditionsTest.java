/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panzgiggerdan.domain;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import panzgiggerdan.conf.factory.TermsAndConditionsFactory;

/**
 *
 * @author Kurt
 */
public class TermsAndConditionsTest {
    
    public TermsAndConditionsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCreateTerm() throws Exception {
       
        Map<String,String> values = new HashMap<String,String>();

        values.put("terms","you may not copy this app it is copyrighted");
       

        TermsAndConditions term =TermsAndConditionsFactory
                .createTerms(values);

        Assert.assertEquals("you may not copy this app it is copyrighted",term.getTerms());
    }

    @Test
    public void testUpdateTerm() throws Exception {
        
         Map<String,String> values = new HashMap<String,String>();

        values.put("terms","you may not copy this app it is copyrighted");
       

        TermsAndConditions term =TermsAndConditionsFactory
                .createTerms(values);


        TermsAndConditions newterm = new TermsAndConditions
                .Builder("copyrighted")
                .build();

        Assert.assertEquals("copyrighted",newterm.getTerms());

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    
}
