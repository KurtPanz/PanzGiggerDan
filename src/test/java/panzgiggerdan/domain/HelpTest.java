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
import panzgiggerdan.conf.factory.HelpFactory;

/**
 *
 * @author Kurt
 */
public class HelpTest {
    
    public HelpTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCreateHelp() throws Exception {
       
        Map<String,String> values = new HashMap<String,String>();

        values.put("helpInformation","add gigg before adding songs");
       

        Help help = HelpFactory
                .createHelp(values);

        Assert.assertEquals("add gigg before adding songs",help.getHelp());
    }

    @Test
    public void testUpdateHelp() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();

        values.put("helpInformation","add gigg before adding songs");
       

        Help help = HelpFactory
                .createHelp(values);

        Assert.assertEquals("add gigg before adding songs",help.getHelp());


        Help newhelp = new Help
                .Builder("tip for today")
                .build();

        Assert.assertEquals("tip for today",newhelp.getHelp());

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
