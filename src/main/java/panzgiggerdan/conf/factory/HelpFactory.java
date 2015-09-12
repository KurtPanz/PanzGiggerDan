package panzgiggerdan.conf.factory;

import java.util.Map;
import panzgiggerdan.domain.Help;

public class HelpFactory {

    public static Help createHelp(
                        Map<String,String> values
                      ){
        Help help = new Help
                .Builder(values.get("helpInformation"))                
                .build();
        
        return help;
    }
        
    public static Help insertHelp(String helpText){
        Help help = new Help
                .Builder(helpText)                
                .build();
        
        return help;
    }
}
