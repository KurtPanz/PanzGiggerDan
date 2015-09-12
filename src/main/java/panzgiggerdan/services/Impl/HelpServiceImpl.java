package panzgiggerdan.services.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panzgiggerdan.conf.factory.HelpFactory;
import panzgiggerdan.domain.Help;
import panzgiggerdan.repository.HelpRepository;
import panzgiggerdan.servicess.HelpService;


@Service
public class HelpServiceImpl implements HelpService{
    @Autowired
    HelpRepository repository;
    public List<Help> getHelp() {
        List<Help> allhelp = new ArrayList<Help>();

        Iterable<Help> help = repository.findAll();
        for (Help helps : help) {
            allhelp.add(helps);
        }
        return allhelp;
    }

    
    @Override
    public String insertHelp(String helpText) {
        Help help = HelpFactory
           .insertHelp(helpText);
        
        return repository.save(help).toString();
    }

    @Override
    public void deleteHelp(Long id) {
       Help help = repository.findOne(id);
       repository.delete(help);
    }
    
}
