package panzgiggerdan.conf.factory;

import java.util.Map;
import panzgiggerdan.domain.TermsAndConditions;

public class TermsAndConditionsFactory {

    public static TermsAndConditions createTerms(
                        Map<String,String> values
                      ){
        TermsAndConditions termsAndConditions = new TermsAndConditions
                .Builder(values.get("terms"))                
                .build();
        
        return termsAndConditions;
    }
}
