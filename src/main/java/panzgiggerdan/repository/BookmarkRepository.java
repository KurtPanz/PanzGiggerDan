package panzgiggerdan.repository;

import java.util.List;
import panzgiggerdan.domain.Bookmark;
import org.springframework.data.repository.CrudRepository;


public interface BookmarkRepository extends CrudRepository<Bookmark,Long>{
    public Bookmark findDistinctBookmarkByName(String name);    
    public List<Bookmark> findByUsernameAndPassword(String username,String password);
}
