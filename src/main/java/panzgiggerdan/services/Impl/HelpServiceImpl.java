package panzgiggerdan.services.Impl;

import panzgiggerdan.domain.Help;
import panzgiggerdan.repository.HelpRepository;
import panzgiggerdan.servicess.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


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
}
