package panzgiggerdan.repository;

import panzgiggerdan.domain.Bookmark;
import org.springframework.data.repository.CrudRepository;


public interface BookmarkRepository extends CrudRepository<Bookmark,Long>{
    public Bookmark findByName(String name);

}
