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
@RequestMapping("panzgiggerdan/api/**")
//@RequestMapping(value="/bookmark/**")
public class HomePage {
    @Autowired
    private BookmarkService service;
    
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

//    @RequestMapping(value = "/bookmark",method = RequestMethod.GET)
//    public Bookmark getBookmark(){
//        Bookmark bookmark = new Bookmark.Builder("lyrics")
//                .link("www.bookmark.co.za").build();
//
//        return bookmark;
//    }

      @RequestMapping(value = "/bookmark",method = RequestMethod.GET)
        public List<Bookmark> getBookmark() {
             return service.getBookmarks();
        }
      
    
//    @RequestMapping(value="/{id}", method= RequestMethod.GET)
//    public List<Bookmark> getBookmark(@PathVariable Long id) {
//
//
//        // ...
//       // return service.getBookmarks(id);
//    }
}
