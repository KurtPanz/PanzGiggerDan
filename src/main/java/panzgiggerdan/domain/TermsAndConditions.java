package panzgiggerdan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class TermsAndConditions implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String terms;
   
   
  

    private TermsAndConditions() {
    }

      public TermsAndConditions(Builder builder){
        terms=builder.terms;        
        id=builder.id;
        
    }

    public Long getId() {
        return id;
    }

    public String getTerms() {
        return terms;
    }

    public static class Builder{
        private Long id;
        private String terms;
       
        
        public Builder(String value) {
            this.terms = value;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }

      
        public Builder copy(TermsAndConditions value){
            this.terms=value.getTerms();            
            this.id=value.getId();
       
            return this;
        }



        public TermsAndConditions build(){
            return new TermsAndConditions(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TermsAndConditions)) return false;

        TermsAndConditions termsAndConditions = (TermsAndConditions) o;

        return !(id != null ? !id.equals(termsAndConditions.id) : termsAndConditions.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Terms And Conditions{" +
                "id=" + id +
                ", name='" + terms + '\'' +
                '}';
    }
}
