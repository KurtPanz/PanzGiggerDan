package panzgiggerdan.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import panzgiggerdan.domain.User;


public interface UserRepository extends CrudRepository<User,Long>{
    public User findByUsername(String username);
    public User findByPassword(String password);
    public User findDistinctUserByUsernameAndPassword(String username,String password);
}
