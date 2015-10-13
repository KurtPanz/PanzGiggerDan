package panzgiggerdan.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import panzgiggerdan.domain.User;
import panzgiggerdan.servicess.UserService;

@RestController
@RequestMapping("panzgiggerdan/UserController")
//@RequestMapping(value="/bookmark/**")
public class UserController {
    @Autowired
    private UserService service;
    
    //
    //GETTERS
    
    //localhost:8080/panzgiggerdan/UserController/User_list
    @RequestMapping(value = "/User_list",method = RequestMethod.GET)
    public List<User> getUser() {
      return service.getUsers();
    }
    
    //SETTERS    
    
    //localhost:8080/panzgiggerdan/UserController/User_insert?username=kurt&password=wasserfall&date=21-March-2015
    @RequestMapping(value = "/User_insert",method = RequestMethod.GET)
    public String insertHelpText(HttpServletRequest request) {
        
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      String date = request.getParameter("date");
      return service.insertUser(username,password,date);
    }
    
    //localhost:8080/panzgiggerdan/UserController/User_login?username=kurt&password=wasserfall
    @RequestMapping(value = "/User_login",method = RequestMethod.GET)
    public List<User> validUser(HttpServletRequest request) {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      return service.validUser(username,password);
    }
    
    //READERS OR DELETERS
    
    //localhost:8080/panzgiggerdan/UserController/User_delete/1
     @RequestMapping(value = "/User_delete/{id}",method = RequestMethod.GET)
     public String delete(@PathVariable  Long id) {
      
      service.deleteUser(id);
      
      return "Successfully removed user with id: " + id;
    }
}
