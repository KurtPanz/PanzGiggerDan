package panzgiggerdan.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import panzgiggerdan.domain.Bookmark;
import panzgiggerdan.servicess.BookmarkService;


@RestController
@RequestMapping("/BookmarkController")
//@RequestMapping(value="/bookmark/**")
public class BookmarkController {
    @Autowired
    private BookmarkService service;
    
    //GETTERS
    @RequestMapping(value = "/Bookmark_list",method = RequestMethod.GET)
    public List<Bookmark> getBookmark() {
      return service.getBookmarks();
    }
    
    //SETTERS
}
