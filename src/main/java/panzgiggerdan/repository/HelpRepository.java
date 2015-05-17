package panzgiggerdan.repository;

import panzgiggerdan.domain.Help;
import org.springframework.data.repository.CrudRepository;


public interface HelpRepository extends CrudRepository<Help,Long>{
    public Help findByHelpInformation(String helpInformation);

}
