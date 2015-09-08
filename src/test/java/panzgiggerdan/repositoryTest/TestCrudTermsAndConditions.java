package panzgiggerdan.repositoryTest;

import panzgiggerdan.repository.TermsAndConditionsRepository;
import panzgiggerdan.App;
import panzgiggerdan.domain.TermsAndConditions;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import panzgiggerdan.repository.TermsAndConditionsRepository;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudTermsAndConditions extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    TermsAndConditionsRepository repository;
    @Test
    public void create() throws Exception {
       
        TermsAndConditions terms = new TermsAndConditions
                .Builder("this is copywrited")
                .build();
        repository.save(terms);
        id=terms.getId();
        Assert.assertNotNull(terms.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        TermsAndConditions terms = repository.findOne(id);
        Assert.assertEquals("this is copywrited",terms.getTerms());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        TermsAndConditions terms = repository.findOne(id);
        
        System.out.println(terms);
        
        TermsAndConditions newterms = new TermsAndConditions
                .Builder("dont ever steal this app")
                .id(terms.getId())
                .build();
        repository.save(newterms);

        TermsAndConditions updatedterms = repository.findOne(id);

        Assert.assertEquals("dont ever steal this app", updatedterms.getTerms());

    }

    @Test(dependsOnMethods = "update", enabled = false)
    public void delete() throws Exception {
         TermsAndConditions terms = repository.findOne(id);
        repository.delete(terms);
         TermsAndConditions newterms = repository.findOne(id);
        Assert.assertNull(newterms);

    }
}
