package panzgiggerdan.repository;

import panzgiggerdan.repository.HelpRepository;
import panzgiggerdan.App;
import panzgiggerdan.domain.Help;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudHelp extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    HelpRepository repository;
    
    @Test
    public void create() throws Exception {
       
        Help help = new Help
                .Builder("step 1: add event")
                .build();
        repository.save(help);
        id=help.getId();
        Assert.assertNotNull(help.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Help help = repository.findOne(id);
        Assert.assertEquals("step 1: add event",help.getHelp());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Help help = repository.findOne(id);
        
        System.out.println(help);
        
        Help newhelp = new Help
                .Builder("step 2:add song")
                .id(help.getId())
                .build();
        repository.save(newhelp);

        Help updatedhelp = repository.findOne(id);

        Assert.assertEquals("step 2:add song", updatedhelp.getHelp());



    }

    @Test(dependsOnMethods = "update", enabled = true)
    public void delete() throws Exception {
         Help help = repository.findOne(id);
        repository.delete(help);
         Help newhelp = repository.findOne(id);
        Assert.assertNull(newhelp);

    }
}
