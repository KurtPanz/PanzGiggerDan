package panzgiggerdan.servicess;

import panzgiggerdan.domain.Bookmark;

import java.util.List;


public interface BookmarkService {
    
     List<Bookmark> getBookmarks();      
     List<Bookmark> getBookmarksByWhere(String username,String password);
     String insertBookmark(String name,String link,String username, String password);
     String updateBookmark(Long id,String name,String link);
     void deleteBookmark(Long id);
}
