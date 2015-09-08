package panzgiggerdan.conf.factory;

import java.util.Map;
import panzgiggerdan.domain.Contact;
import panzgiggerdan.domain.Register;

public class RegisterFactory {
public static Register createUser(Map<String,String> values){
        
        Contact contact = new Contact.Builder().cellNumber("0721111111").phoneNumber("021-7014239").build();

        Register register = new Register
                .Builder(values.get("userName"))
                .password(values.get("password"))   
                .confirmationPassword(values.get("confirmationPassword"))
                .Contact(contact)
                .build();
        
        return register;
    }
    
}
