package panzgiggerdan.repository;

import panzgiggerdan.domain.Songs;
import org.springframework.data.repository.CrudRepository;


public interface SongRepository extends CrudRepository<Songs,Long>{
    public Songs findBySongName(String songName);

}
