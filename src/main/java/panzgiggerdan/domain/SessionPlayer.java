package panzgiggerdan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class SessionPlayer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    private String userName;
    private String password; 
   
  

    private SessionPlayer() {
    }

      public SessionPlayer(Builder builder){
        userName=builder.userName;
        password=builder.password;
        id=builder.id;
        
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
 

    public static class Builder{
        private Long id;
        private String userName;
        private String password;
        
        public Builder(String value) {
            this.userName = value;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }

          

        public Builder id(Long value){
            this.id=value;
            return this;
        }

      
        public Builder copy(SessionPlayer value){
            this.userName=value.getUserName();
            this.password=value.getPassword();      
            this.id=value.getId();
       
            return this;
        }



        public SessionPlayer build(){
            return new SessionPlayer(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SessionPlayer)) return false;

        SessionPlayer sessionplayer = (SessionPlayer) o;

        return !(id != null ? !id.equals(sessionplayer.id) : sessionplayer.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SessionPlayer{" +
                "id=" + id +
                ", Username='" + userName + '\'' +
                '}';
    }
}
