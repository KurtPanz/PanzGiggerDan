package panzgiggerdan.conf.factory;

import panzgiggerdan.domain.Bookmark;


import java.util.Map;

public class BookmarkFactory {

    public static Bookmark createBookmark(Map<String,String> values){
        Bookmark bookmark = new Bookmark
                .Builder(values.get("name"))
                .link(values.get("link"))                
                .build();
        
        return bookmark;
    }
}
