package panzgiggerdan.repository;

import panzgiggerdan.domain.TermsAndConditions;
import org.springframework.data.repository.CrudRepository;


public interface TermsAndConditionsRepository extends CrudRepository<TermsAndConditions,Long>{
    public TermsAndConditions findByTerms(String terms);

}
