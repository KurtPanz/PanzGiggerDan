package panzgiggerdan.repository;

import panzgiggerdan.repository.RegisterRepository;
import panzgiggerdan.App;
import panzgiggerdan.domain.Register;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudRegister extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    RegisterRepository repository;
    
    @Test
    public void create() throws Exception {
        System.out.println( "TestCrudRegister create");
        
        Register register = new Register
                .Builder("liras band")
                .password("12345")
                .confirmationPassword("12345")
                .build();
        
        repository.save(register);
        id=register.getId();
        Assert.assertNotNull(register.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Register register = repository.findOne(id);
        Assert.assertEquals("liras band",register.getUserName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Register register = repository.findOne(id);
        
        System.out.println(register);
        
        Register newregister = new Register
                .Builder(register.getUserName())
                .id(register.getId())
                .password("12345")
                .confirmationPassword("12345")
                .build();
        
        repository.save(newregister);

        Register updatedRegister = repository.findOne(id);

        Assert.assertEquals("12345", updatedRegister.getPassword());
         Assert.assertEquals("12345", updatedRegister.getConfirmationPassword());



    }

    @Test(dependsOnMethods = "update", enabled = true)
    public void delete() throws Exception {
        Register register = repository.findOne(id);
        repository.delete(register);
        Register newRegister = repository.findOne(id);
        Assert.assertNull(newRegister);

    }
}
