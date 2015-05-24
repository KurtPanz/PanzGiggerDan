package panzgiggerdan.model;

import panzgiggerdan.domain.*;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;



public class BookmarkResource extends ResourceSupport{
   
    private Long resid;   
    private String name;
    private String link; 
   
  

    private BookmarkResource() {
    }

      public BookmarkResource(Builder builder){
        name=builder.name;
        link=builder.link;
        resid=builder.resid;
        
    }

    public Long getResid() {
        return resid;
    }

    public String getName() {
        return name;
    }
    
   public String getLink() {
   
     return link;
    }
 

    public static class Builder{
        private Long resid;
        private String name;
        private String link;
        
        public Builder(String value) {
            this.name = value;
        }

        public Builder link(String value){
            this.link=value;
            return this;
        }

          

        public Builder resid(Long value){
            this.resid=value;
            return this;
        }

      
        public Builder copy(BookmarkResource value){
            this.name=value.name;
            this.link=value.link;      
            this.resid=value.resid;
       
            return this;
        }



        public BookmarkResource build(){
            return new BookmarkResource(this);
        }

    }

}
