package panzgiggerdan.services.Impl;

import panzgiggerdan.domain.Register;
import panzgiggerdan.repository.RegisterRepository;
import panzgiggerdan.servicess.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Service
public class RegisterServiceImpl  implements RegisterService{
    @Autowired
    RegisterRepository repository;
    
    public List<Register> getRegisteredUsers() {
        List<Register> allusers = new ArrayList<Register>();

        Iterable<Register> users = repository.findAll();
        for (Register registered : users) {
            allusers.add(registered);
        }
        return allusers;
    }
}
