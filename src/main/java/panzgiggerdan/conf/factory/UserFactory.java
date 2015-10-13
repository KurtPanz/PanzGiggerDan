package panzgiggerdan.conf.factory;

import java.util.Map;
import panzgiggerdan.domain.User;

public class UserFactory {

    public static User createUser(
                        Map<String,String> values
                      ){
        User user = new User
                .Builder(values.get("username")) 
                .password(values.get("password")) 
                .date(values.get("date")) 
                .build();
        
        return user;
    }
        
    public static User insertUser(String username, String password, String date){
        User user = new User
                .Builder(username)    
                .password(password) 
                .date(date) 
                .build();
        
        return user;
    }
}
