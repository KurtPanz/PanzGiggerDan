package panzgiggerdan.services.Impl;

import panzgiggerdan.domain.Bookmark;
import panzgiggerdan.repository.BookmarkRepository;
import panzgiggerdan.servicess.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Service
public class BookmarkServiceImpl  implements BookmarkService{
    @Autowired
    BookmarkRepository repository;
    public List<Bookmark> getBookmarks() {
        List<Bookmark> allbookmarks = new ArrayList<Bookmark>();

        Iterable<Bookmark> bookmarks = repository.findAll();
        for (Bookmark bookmark : bookmarks) {
            allbookmarks.add(bookmark);
        }
        return allbookmarks;
    }
}
