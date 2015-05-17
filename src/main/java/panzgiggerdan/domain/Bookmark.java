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
   
  

    private Bookmark() {
    }

      public Bookmark(Builder builder){
        name=builder.name;
        link=builder.link;
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
 

    public static class Builder{
        private Long id;
        private String name;
        private String link;
        
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

      
        public Builder copy(Bookmark value){
            this.name=value.getName();
            this.link=value.getLink();      
            this.id=value.getId();
       
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
                '}';
    }
}
