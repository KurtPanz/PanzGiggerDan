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
import panzgiggerdan.conf.factory.RegisterFactory;

/**
 *
 * @author Kurt
 */
public class RegisteredPlayerTest {
    
    public RegisteredPlayerTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
    public void testRegister() throws Exception {
       
        Map<String,String> values = new HashMap<String,String>();

        values.put("userName","something good");
        values.put("password", "123456");
        values.put("confirmationPassword", "123456");

        Register register = RegisterFactory
                .createUser(values);
                

        Assert.assertEquals("something good",register.getUserName());
        Assert.assertEquals("123456",register.getPassword());
        Assert.assertEquals("123456",register.getConfirmationPassword());
    }

    @Test
    public void testUpdateRegister() throws Exception {
        
       Map<String,String> values = new HashMap<String,String>();

        values.put("userName","something good");
        values.put("password", "123456");
        values.put("confirmationPassword", "123456");

        Register register = RegisterFactory
                .createUser(values);
                

         Register newregister = new Register
                .Builder(register.getUserName())
                .copy(register)
                .password("1232345").build();

        Assert.assertEquals("something good",newregister.getUserName());
        Assert.assertEquals("1232345",newregister.getPassword());
        Assert.assertEquals("123456",newregister.getConfirmationPassword());
     

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
