package panzgiggerdan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String username;
    private String password;
    private String date;
   
   
  

    private User() {
    }

    public User(Builder builder){
        username=builder.username;
        password=builder.password; 
        date=builder.date; 
        id=builder.id;
        
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getDate() {
        return date;
    }
    

    public static class Builder{
        private Long id;
        private String username;
        private String password;
        private String date;
       
        
        public Builder(String value) {
            this.username = value;
        }
        
        public Builder password(String value) {
            this.password = value;
            return this;
        }
        
        public Builder date(String value) {
            this.date = value;
            return this;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }

      
        public Builder copy(User value){
            this.username=value.getUsername(); 
            this.password=value.getPassword(); 
            this.date=value.getDate(); 
            this.id=value.getId();
       
            return this;
        }



        public User build(){
            return new User(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return !(id != null ? !id.equals(user.id) : user.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Help{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
