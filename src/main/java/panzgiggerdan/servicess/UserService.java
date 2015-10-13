package panzgiggerdan.servicess;

import panzgiggerdan.domain.User;

import java.util.List;


public interface UserService {
     List<User> getUsers();
     List<User> validUser(String username,String password);
     String insertUser(String username,String password,String date);
     void deleteUser(Long id);
}
