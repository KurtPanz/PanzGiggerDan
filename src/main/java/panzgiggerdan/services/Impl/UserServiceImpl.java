package panzgiggerdan.services.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panzgiggerdan.conf.factory.UserFactory;
import panzgiggerdan.domain.User;
import panzgiggerdan.repository.UserRepository;
import panzgiggerdan.servicess.UserService;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;
    
    public List<User> getUsers() {
        List<User> allusers = new ArrayList<User>();

        Iterable<User> user = repository.findAll();
        
        for (User users : user) {
            allusers.add(users);
        }
        return allusers;
    }
    
     public List<User> validUser(String username,String password) {
         
        List<User> validuser = new ArrayList<User>();
        User user = repository.findDistinctUserByUsernameAndPassword(username, password);  
         
        if(user != null)
        {
            validuser.add(user);
            return validuser;
        }
        
        return validuser;        
    }

    
    @Override
    public String insertUser(String username,String password,String date) {        
         User user = UserFactory
            .insertUser(username,password,date);
        //check if user with name and surname exist then dont add
        User users = repository.findDistinctUserByUsernameAndPassword(username, password);
        
        if(users != null)
        {
          if(users.getUsername().equals(username) && users.getPassword().equals(password))
          {
            return "user already exists.";
          }
        }        
                  
        return repository.save(user).toString();
                
    }

    @Override
    public void deleteUser(Long id) {
       User user = repository.findOne(id);
       repository.delete(user);
    }
    
}
