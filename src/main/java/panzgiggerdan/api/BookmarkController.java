package panzgiggerdan.api;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import panzgiggerdan.domain.Bookmark;
import panzgiggerdan.servicess.BookmarkService;


@RestController
@RequestMapping("panzgiggerdan/BookmarkController")
//@RequestMapping(value="/bookmark/**")
public class BookmarkController {
    @Autowired
    private BookmarkService service;
    
    //GETTERS
    //localhost:8080/panzgiggerdan/BookmarkController/Bookmark_list
    @RequestMapping(value = "/Bookmark_list",method = RequestMethod.GET)
    public List<Bookmark> getBookmark() {
      return service.getBookmarks();
    }
    
     //localhost:8080/panzgiggerdan/BookmarkController/Bookmark_listByWhere?username=kurt&password=was
    @RequestMapping(value = "/Bookmark_listByWhere",method = RequestMethod.GET)
    public List<Bookmark> getBookmarksByWhere(HttpServletRequest request) {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      return service.getBookmarksByWhere(username,password);
    }
    
    //SETTERS
    
    //localhost:8080/panzgiggerdan/BookmarkController/Bookmark_insert?name=az lyrics&link=www.musica.com&username=kurt&password=was
    @RequestMapping(value = "/Bookmark_insert",method = RequestMethod.GET)
    public String insertBookmark(HttpServletRequest request) {
        
      String name = request.getParameter("name");
      String link = request.getParameter("link"); 
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      String date = request.getParameter("date");
      
      return service.insertBookmark(name,link,username,password);
    }
    
    //localhost:8080/panzgiggerdan/BookmarkController/Bookmark_update?id=40&name=az lyrics&link=www.musica.com
    @RequestMapping(value = "/Bookmark_update",method = RequestMethod.GET)
    public String updateBookmark(HttpServletRequest request) {
        
      String name = request.getParameter("name");
      String link = request.getParameter("link"); 
      String id = request.getParameter("id");
      
      return service.updateBookmark(Long.parseLong(id),name,link);
    }
    
    //READERS OR DELETERS
    
     //localhost:8080/panzgiggerdan/BookmarkController/Bookmark_delete/1
     @RequestMapping(value = "/Bookmark_delete/{id}",method = RequestMethod.GET)
     public String delete(@PathVariable  Long id) {
      
      service.deleteBookmark(id);
      
      return "Successfully removed bookmark with id: " + id;
    }
}