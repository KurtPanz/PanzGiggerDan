package panzgiggerdan.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import panzgiggerdan.domain.Help;
import panzgiggerdan.servicess.HelpService;

@RestController
@RequestMapping("panzgiggerdan/HelpController")
//@RequestMapping(value="/bookmark/**")
public class HelpController {
    @Autowired
    private HelpService service;
    
    
    //GETTERS
    
    //localhost:8080/panzgiggerdan/HelpController/Help_list
    @RequestMapping(value = "/Help_list",method = RequestMethod.GET)
    public List<Help> getHelp() {
      return service.getHelp();
    }
    
    //SETTERS    
    
    //localhost:8080/panzgiggerdan/HelpController/Help_insert?helptext=step:4 Now you need to add this to consideration
    @RequestMapping(value = "/Help_insert",method = RequestMethod.GET)
    public String insertHelpText(HttpServletRequest request) {
        
      String helpText = request.getParameter("helptext");
      return service.insertHelp(helpText);
    }
    
    //READERS OR DELETERS
    
    //localhost:8080/panzgiggerdan/HelpController/Help_delete/1
     @RequestMapping(value = "/Help_delete/{id}",method = RequestMethod.GET)
     public String delete(@PathVariable  Long id) {
      
      service.deleteHelp(id);
      
      return "Successfully removed help item with id: " + id;
    }
}
