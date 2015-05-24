package panzgiggerdan.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import panzgiggerdan.domain.Bookmark;
import panzgiggerdan.model.BookmarkResource;
import panzgiggerdan.servicess.BookmarkService;



@RestController
@RequestMapping(value="/Bookmark/**")
public class BookmarkPage {
    @Autowired
    private BookmarkService service;
    
//    @RequestMapping(value="/{id}", method= RequestMethod.GET)
//    public List<BookmarkService> getBookmarks(@PathVariable Long id) {
//
//
//        // ...
//        return service.getBookmarks(id);
//    }
//
//    @RequestMapping(value="/{id}/departments", method=RequestMethod.GET)
//    List<Department> getFacultyDepartments(@PathVariable Long id) {
//        // ...
//    }
//
    @RequestMapping(value="/Bookmarks", method=RequestMethod.GET)
    public List<BookmarkResource> getBookmarks() {
        List<BookmarkResource> hateos = new ArrayList<>();
        List<Bookmark> bookmarks = service.getBookmarks();
        for (Bookmark bookmark : bookmarks) {
            BookmarkResource res = new BookmarkResource
                    .Builder(bookmark.getName())
                    .link(bookmark.getLink())
                    .resid(bookmark.getId())
                    .build();
            
            Link allBookmarks = new
                    Link("http://localhost:8080/Bookmarks/" + res.getResid().toString())
                    .withRel("bookmarks");
            res.add(allBookmarks);
            hateos.add(res);
        }
        return hateos;
    }
//

}
