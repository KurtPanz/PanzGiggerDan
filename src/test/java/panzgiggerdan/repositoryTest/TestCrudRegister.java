package panzgiggerdan.repositoryTest;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import panzgiggerdan.App;
import panzgiggerdan.domain.Contact;
import panzgiggerdan.domain.Register;
import panzgiggerdan.repository.RegistersRepository;



@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudRegister extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    RegistersRepository repository;
    
    @Test
    public void create() throws Exception {
        System.out.println( "TestCrudRegister create");
         //embedded population
        Contact contact = new Contact.Builder().cellNumber("0721111111").phoneNumber("021-7014239").build();
        
        Register register = new Register
                .Builder("liras band")
                .password("12345")
                .confirmationPassword("12345")
                .Contact(contact)
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
        
        Contact contact = new Contact.Builder().cellNumber("0721111111").phoneNumber("021-7014239").build();
        
        Register newregister = new Register
                .Builder(register.getUserName())
                .id(register.getId())
                .password("12345")
                .confirmationPassword("12345")
                .Contact(contact)
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
