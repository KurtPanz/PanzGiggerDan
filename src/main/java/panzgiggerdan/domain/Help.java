package panzgiggerdan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Help implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String helpInformation;
   
   
  

    private Help() {
    }

      public Help(Builder builder){
        helpInformation=builder.helpInformation;        
        id=builder.id;
        
    }

    public Long getId() {
        return id;
    }

    public String getHelp() {
        return helpInformation;
    }

    public static class Builder{
        private Long id;
        private String helpInformation;
       
        
        public Builder(String value) {
            this.helpInformation = value;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }

      
        public Builder copy(Help value){
            this.helpInformation=value.getHelp();            
            this.id=value.getId();
       
            return this;
        }



        public Help build(){
            return new Help(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Help)) return false;

        Help help = (Help) o;

        return !(id != null ? !id.equals(help.id) : help.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Help{" +
                "id=" + id +
                ", helpInformation='" + helpInformation + '\'' +
                '}';
    }
}
