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
import panzgiggerdan.conf.factory.BookmarkFactory;

/**
 *
 * @author Kurt
 */
public class BookmarkTest {
    
    public BookmarkTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
    public void testCreateBookmark() throws Exception {
       
        Map<String,String> values = new HashMap<String,String>();

        values.put("name","lyrics");
        values.put("link", "www.cput.ac.za");

        Bookmark bookmark =BookmarkFactory
                .createBookmark(values);

        Assert.assertEquals("lyrics",bookmark.getName());
        Assert.assertEquals("www.cput.ac.za",bookmark.getLink());
    }

    @Test
    public void testUpdateBookmark() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();

        values.put("name","lyrics");
        values.put("link", "www.cput.ac.za");
        
        Bookmark bookmark =BookmarkFactory
                .createBookmark(values);

        Bookmark newbookmark = new Bookmark
                .Builder(bookmark.getName())
                .copy(bookmark)
                .link("www.lyrical.com").build();

        Assert.assertEquals("lyrics",newbookmark.getName());
        Assert.assertEquals("www.lyrical.com",newbookmark.getLink());
     

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
