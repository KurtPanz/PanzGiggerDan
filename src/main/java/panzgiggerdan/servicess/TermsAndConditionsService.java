package panzgiggerdan.servicess;

import panzgiggerdan.domain.TermsAndConditions;

import java.util.List;


public interface TermsAndConditionsService {
     List<TermsAndConditions> getTerms();
     String insertTermsAndConditions(String termsText);
     void deleteTerm(Long id);
}
