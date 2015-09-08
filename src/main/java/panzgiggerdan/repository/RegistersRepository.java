package panzgiggerdan.repository;

import panzgiggerdan.domain.Register;
import org.springframework.data.repository.CrudRepository;


public interface RegistersRepository extends CrudRepository<Register,Long>{
    public Register findByUserName(String userName);

}
