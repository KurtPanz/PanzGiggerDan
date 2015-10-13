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
import panzgiggerdan.conf.factory.UserFactory;

/**
 *
 * @author Kurt
 */
public class UserTest {
    
    public UserTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCreateUser() throws Exception {
       
        Map<String,String> values = new HashMap<String,String>();

        values.put("username","admin");
        values.put("password","password");
        values.put("date","21-March-2015");
       

        User user = UserFactory
                .createUser(values);

        Assert.assertEquals("admin",user.getUsername());
        Assert.assertEquals("password",user.getPassword());
    }

    @Test
    public void testUpdateUser() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();

        values.put("username","admin");
        values.put("password","password");
        values.put("date","21-March-2015");
        
        User user = UserFactory
                .createUser(values);

        Assert.assertEquals("admin",user.getUsername());
        Assert.assertEquals("password",user.getPassword());

        User newuser = new User
                .Builder("admin2")
                .password("password2")
                .password("21-March-2015")
                .build();

        Assert.assertEquals("admin2", newuser.getUsername());

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
