package panzgiggerdan.conf.factory;

import panzgiggerdan.domain.Bookmark;


import java.util.Map;

public class BookmarkFactory {

    public static Bookmark createBookmark(Map<String,String> values){
        Bookmark bookmark = new Bookmark
                .Builder(values.get("name"))
                .link(values.get("link")) 
                .username(values.get("username")) 
                .password(values.get("password")) 
                .build();
        
        return bookmark;
    }
    
    public static Bookmark insertBookmark(String name,String link,String username, String password){
         Bookmark bookmark = new Bookmark
                .Builder(name)
                .link(link) 
                .username(username) 
                .password(password) 
                .build();
        
        return bookmark;
    }
    
    public static Bookmark updateBookmark(Long id,String name,String link,String username,String password){
         Bookmark bookmark = new Bookmark
                .Builder(name)
                .link(link)                
                .id(id)
                .build();
         
        return bookmark;
    }
}
