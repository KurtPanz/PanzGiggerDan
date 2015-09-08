package panzgiggerdan.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.metamodel.source.annotations.entity.EmbeddableClass;


@Entity
public class Register implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    private String userName;
    private String password; 
    private String confirmationPassword;
    @Embedded
    private Contact contact;
   
  

    private Register() {
    }

      public Register(Builder builder){
        userName=builder.userName;
        password=builder.password;
        confirmationPassword=builder.confirmationPassword;
        id=builder.id;
        contact=builder.contact;
        
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
    
   public String getPassword() {
   
     return password;
    }
   
    public String getConfirmationPassword() {
   
     return confirmationPassword;
    }
    
     public Contact getContact() {
     return contact;
    }
 

    public static class Builder{
        private Long id;
        private String userName;
        private String password;
        private String confirmationPassword;
        private Contact contact;
        
        public Builder(String value) {
            this.userName = value;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }
        
         public Builder confirmationPassword(String value){
            this.confirmationPassword=value;
            return this;
        }

          

        public Builder id(Long value){
            this.id=value;
            return this;
        }
 
         public Builder Contact(Contact value){
            this.contact=value;
            return this;
        }
      
        public Builder copy(Register value){
            this.userName=value.getUserName();
            this.password=value.getPassword();  
            this.confirmationPassword=value.getConfirmationPassword();
            this.id=value.getId();
            this.contact=value.getContact();
       
            return this;
        }



        public Register build(){
            return new Register(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Register)) return false;

        Register register = (Register) o;

        return !(id != null ? !id.equals(register.id) : register.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", Username='" + userName + '\'' +
                '}';
    }
}
