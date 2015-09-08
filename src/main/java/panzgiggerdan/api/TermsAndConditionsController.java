package panzgiggerdan.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import panzgiggerdan.domain.TermsAndConditions;
import panzgiggerdan.servicess.TermsAndConditionsService;


@RestController
@RequestMapping("/TermsAndConditionsController")
//@RequestMapping(value="/bookmark/**")
public class TermsAndConditionsController {
    @Autowired
    private TermsAndConditionsService service;
    
    //GETTERS
    @RequestMapping(value = "/TermsAndConditions_list",method = RequestMethod.GET)
    public List<TermsAndConditions> getTerm() {
      return service.getTerms();
    }
    
    //SETTERS
}
