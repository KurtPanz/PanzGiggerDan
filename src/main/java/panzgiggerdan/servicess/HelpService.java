package panzgiggerdan.servicess;

import panzgiggerdan.domain.Help;

import java.util.List;


public interface HelpService {
     List<Help> getHelp();
     String insertHelp(String helpText);
     void deleteHelp(Long id);
}
