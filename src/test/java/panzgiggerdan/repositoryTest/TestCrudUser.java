package panzgiggerdan.repositoryTest;

import panzgiggerdan.repository.UserRepository;
import panzgiggerdan.App;
import panzgiggerdan.domain.User;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import panzgiggerdan.repository.UserRepository;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudUser extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    UserRepository repository;
    
    @Test
    public void create() throws Exception {
       
        User user = new User
                .Builder("admin")
                .password("password")
                .date("21-June-2015")
                .build();
        repository.save(user);
        id=user.getId();
        Assert.assertNotNull(user.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User user = repository.findOne(id);
        Assert.assertEquals("admin",user.getUsername());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User user = repository.findOne(id);
        
        System.out.println(user);
        
        User newuser = new User
                .Builder("admin2")
                .id(user.getId())
                .password(user.getPassword())
                .date(user.getDate())
                .build();
        repository.save(newuser);

        User updateduser = repository.findOne(id);

        Assert.assertEquals("admin2", updateduser.getUsername());



    }

    @Test(dependsOnMethods = "update", enabled = false)
    public void delete() throws Exception {
         User user = repository.findOne(id);
         repository.delete(user);
         User newuser = repository.findOne(id);
         Assert.assertNull(newuser);

    }
}
