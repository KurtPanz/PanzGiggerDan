package panzgiggerdan.repository;

import panzgiggerdan.repository.SessionPlayerRepository;
import panzgiggerdan.App;
import panzgiggerdan.domain.SessionPlayer;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudSessionPlayer extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    SessionPlayerRepository repository;
    @Test
    public void create() throws Exception {
        System.out.println( "TestCrudSessionPlayer create");
        
        SessionPlayer sessionplayer = new SessionPlayer
                .Builder("liras band")
                .password("FeelGood").build();
        
        repository.save(sessionplayer);
        id=sessionplayer.getId();
        Assert.assertNotNull(sessionplayer.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        SessionPlayer sessionplayer = repository.findOne(id);
        Assert.assertEquals("liras band",sessionplayer.getUserName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        SessionPlayer sessionplayer = repository.findOne(id);
        
        System.out.println(sessionplayer);
        
        SessionPlayer newsessionplayer = new SessionPlayer
                .Builder(sessionplayer.getUserName())
                .id(sessionplayer.getId())
                .password("12345").build();
        
        repository.save(newsessionplayer);

        SessionPlayer updatedSessionPlayer = repository.findOne(id);

        Assert.assertEquals("12345", updatedSessionPlayer.getPassword());



    }

    @Test(dependsOnMethods = "update", enabled = true)
    public void delete() throws Exception {
        SessionPlayer sessionplayer = repository.findOne(id);
        repository.delete(sessionplayer);
        SessionPlayer newSessionPlayer = repository.findOne(id);
        Assert.assertNull(newSessionPlayer);

    }
}
