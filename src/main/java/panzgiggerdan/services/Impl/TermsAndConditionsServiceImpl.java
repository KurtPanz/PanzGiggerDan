package panzgiggerdan.services.Impl;

import panzgiggerdan.domain.TermsAndConditions;
import panzgiggerdan.repository.TermsAndConditionsRepository;
import panzgiggerdan.servicess.TermsAndConditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Service
public class TermsAndConditionsServiceImpl implements TermsAndConditionsService{
    @Autowired
    TermsAndConditionsRepository repository;
    public List<TermsAndConditions> getTerms() {
        List<TermsAndConditions> allterms = new ArrayList<TermsAndConditions>();

        Iterable<TermsAndConditions> termsAndconditions = repository.findAll();
        for (TermsAndConditions terms : termsAndconditions) {
            allterms.add(terms);
        }
        return allterms;
    }
}
