package panzgiggerdan.services.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panzgiggerdan.conf.factory.BookmarkFactory;
import panzgiggerdan.domain.Bookmark;
import panzgiggerdan.repository.BookmarkRepository;
import panzgiggerdan.servicess.BookmarkService;


@Service
public class BookmarkServiceImpl  implements BookmarkService{
    @Autowired
    BookmarkRepository repository;
    
    @Override
    public List<Bookmark> getBookmarks() {
        List<Bookmark> allbookmarks = new ArrayList<Bookmark>();

        Iterable<Bookmark> bookmarks = repository.findAll();
        for (Bookmark bookmark : bookmarks) {
            allbookmarks.add(bookmark);
        }
        return allbookmarks;
    }
    
    @Override
    public List<Bookmark> getBookmarksByWhere(String username,String password) {
         
        List<Bookmark> allbookmarks = new ArrayList<Bookmark>();

        Iterable<Bookmark> bookmarks = repository.findByUsernameAndPassword(username, password);
        
        for (Bookmark bookmark : bookmarks) {
            allbookmarks.add(bookmark);
        }
        return allbookmarks;        
    }
    
    @Override
    public String insertBookmark(String name,String link,String username,String password) {        
         Bookmark bookmark = BookmarkFactory
            .insertBookmark(name, link, username, password);
        //check if user with name and surname exist then dont add
        Bookmark bookmarks = repository.findDistinctBookmarkByName(name);
        
        if(bookmarks != null)
        {
          if(bookmarks.getName().equals(name))
          {
            return "Bookmark already exists.";
          }
        }        
                  
        return repository.save(bookmark).toString();
                
    }
    
    @Override
    public String updateBookmark(Long id,String name,String link, String username, String password) {  
        
         //check if user with name and surname exist then dont add
        Bookmark bookmark = repository.findOne(id);
        
          if(bookmark == null)
          {
             return "Bookmark does not exists.";
          }
        
        Bookmark newbookmark = BookmarkFactory
            .updateBookmark(id,name,link,username,password);
         
        if(newbookmark.getId()!= bookmark.getId())
        {           
           return "Bookmark does not exists.";
        }        
         
        return repository.save(newbookmark).toString();
   }
    
    @Override
    public void deleteBookmark(Long id) {
       Bookmark bookmark = repository.findOne(id);
       
       if(bookmark != null)
       {
         repository.delete(bookmark);
       }
       
    }
}
