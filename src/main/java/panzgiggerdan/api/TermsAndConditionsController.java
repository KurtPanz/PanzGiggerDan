package panzgiggerdan.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
    
     //localhost:8080/TermsAndConditionsController/TermsAndConditions_list
    @RequestMapping(value = "/TermsAndConditions_list",method = RequestMethod.GET)
    public List<TermsAndConditions> getTerm() {
      return service.getTerms();
    }
    
    //SETTERS    
    
    //localhost:8080/TermsAndConditionsController/TermsAndConditions_insert?termsandconsText=you cannot use this app, with the intenstion of using it.
    @RequestMapping(value = "/TermsAndConditions_insert",method = RequestMethod.GET)
    public String insertTermsText(HttpServletRequest request) {        
      String termsText = request.getParameter("termsandconsText");
      return service.insertTermsAndConditions(termsText);
    }

    //localhost:8080/TermsAndConditionsController/TermsAndConditions_delete/1
     @RequestMapping(value = "/TermsAndConditions_delete/{id}",method = RequestMethod.GET)
     public String delete(@PathVariable  Long id) {
      
      service.deleteTerm(id);
      
      return "Successfully removed terms and conditions item with id: " + id;
    }
}
