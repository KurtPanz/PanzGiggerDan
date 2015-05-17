package panzgiggerdan.conf.factory;

import panzgiggerdan.domain.Register;


import java.util.Map;

public class RegisterFactory {

    public static Register createUser(Map<String,String> values){
        Register register = new Register
                .Builder(values.get("userName"))
                .password(values.get("password"))   
                .confirmationPassword(values.get("confirmationPassword"))
                .build();
        
        return register;
    }
}
