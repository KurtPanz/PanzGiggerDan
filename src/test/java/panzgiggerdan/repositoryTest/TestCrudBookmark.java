package panzgiggerdan.repositoryTest;

import panzgiggerdan.repository.BookmarkRepository;
import panzgiggerdan.App;
import panzgiggerdan.domain.Bookmark;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import panzgiggerdan.repository.BookmarkRepository;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBookmark extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    BookmarkRepository repository;
    @Test
    public void create() throws Exception {
        System.out.println( "TestCrudBookmark create");
        Bookmark bookmark = new Bookmark
                .Builder("lyrics")
                .link("www.getlyrics.com").build();
        repository.save(bookmark);
        id=bookmark.getId();
        Assert.assertNotNull(bookmark.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Bookmark bookmark = repository.findOne(id);
        Assert.assertEquals("lyrics",bookmark.getName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Bookmark bookmark = repository.findOne(id);
        
        System.out.println(bookmark);
        
        Bookmark newbookmark = new Bookmark
                .Builder(bookmark.getName())
                .id(bookmark.getId())
                .link("www.azlyrics.com").build();
        repository.save(newbookmark);

        Bookmark updatedbookmark = repository.findOne(id);

        Assert.assertEquals("www.azlyrics.com", updatedbookmark.getLink());



    }

    @Test(dependsOnMethods = "update", enabled = true)
    public void delete() throws Exception {
        Bookmark bookmark = repository.findOne(id);
        repository.delete(bookmark);
        Bookmark newbookmark = repository.findOne(id);
        Assert.assertNull(newbookmark);

    }
}
