package panzgiggerdan.repository;

import panzgiggerdan.domain.SessionPlayer;
import org.springframework.data.repository.CrudRepository;


public interface SessionPlayerRepository extends CrudRepository<SessionPlayer,Long>{
    public SessionPlayer findByUserName(String userName);

}
