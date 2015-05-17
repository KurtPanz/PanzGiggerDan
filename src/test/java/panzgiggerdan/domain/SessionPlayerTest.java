/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panzgiggerdan.domain;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import panzgiggerdan.conf.factory.SessionPlayerFactory;

/**
 *
 * @author Kurt
 */
public class SessionPlayerTest {
    
    public SessionPlayerTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
    public void testCreateSessionPlayer() throws Exception {
       
        Map<String,String> values = new HashMap<String,String>();

        values.put("userName","chazing time band");
        values.put("password", "123456");

        SessionPlayer sessionplayer =SessionPlayerFactory
                .createSessionPlayer(values);

        Assert.assertEquals("chazing time band",sessionplayer.getUserName());
        Assert.assertEquals("123456",sessionplayer.getPassword());
    }

    @Test
    public void testUpdateSessionPlayer() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();

        values.put("userName","chazing time band");
        values.put("password", "123456");

        SessionPlayer sessionplayer =SessionPlayerFactory
                .createSessionPlayer(values);

        SessionPlayer newsessionplayer = new SessionPlayer
                .Builder(sessionplayer.getUserName())
                .copy(sessionplayer)
                .password("1232345").build();

        Assert.assertEquals("chazing time band",newsessionplayer.getUserName());
        Assert.assertEquals("1232345",newsessionplayer.getPassword());
     

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
