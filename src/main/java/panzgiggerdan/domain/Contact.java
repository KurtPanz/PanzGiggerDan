package panzgiggerdan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Embeddable
public class Contact implements Serializable{
   
    public String phoneNumber ;
    public String cellNumber ;

    private Contact() {
    }

    public Contact(Builder builder){
          phoneNumber = builder.phoneNumber;
          cellNumber= builder.cellNumber;
    }

    public static class Builder
    {
    private String phoneNumber;
    private String cellNumber;
    
    public Builder phoneNumber(String value)
    {
        this.phoneNumber = value;
        return this;
    }
    
     public Builder cellNumber(String value)
    {
        this.cellNumber = value;
        return this;
    }
    
    public Builder Contact(Contact contact)
    {
        
        phoneNumber = contact.getPhoneNumber();
        cellNumber = contact.getCellNumber();
        
        return this;
    }
     
     
     
      public Contact build()
    {
        return new Contact(this);
    }

                
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }
}
