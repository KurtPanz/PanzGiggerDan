package panzgiggerdan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Bookmark implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String link; 
    private String username;
    private String password; 
   
  

    private Bookmark() {
    }

      public Bookmark(Builder builder){
        name=builder.name;
        link=builder.link;
        username=builder.username;
        password=builder.password;
        id=builder.id;
        
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
   public String getLink() {
   
     return link;
    }
    
   public String getUsername() {
        return username;
    }
   
   public String getPassword() {
        return password;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String link;
        private String username;
        private String password;
        
        
        public Builder(String value) {
            this.name = value;
        }

        public Builder link(String value){
            this.link=value;
            return this;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder username(String value){
            this.username=value;
            return this;
        }
        
        public Builder password(String value){
            this.password=value;
            return this;
        }

      
        public Builder copy(Bookmark value){
            this.name=value.getName();
            this.link=value.getLink();                          
            this.id=value.getId();
            this.username=value.getName();
            this.password=value.getLink(); 
       
            return this;
        }



        public Bookmark build(){
            return new Bookmark(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bookmark)) return false;

        Bookmark bookmark = (Bookmark) o;

        return !(id != null ? !id.equals(bookmark.id) : bookmark.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
