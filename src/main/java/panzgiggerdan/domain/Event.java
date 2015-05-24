/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panzgiggerdan.domain;


import java.io.Serializable;
import java.util.*;
import javax.persistence.*;



@Entity
public class Event implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    //@Column(unique = true)
    private String eventName;
    private String venue;    
    private Date date;
    private Date time;
    private String comments;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="event_id")
    private List<Songs> songs;

    private Event() {
    }

   public Event(Builder builder){
        
        id=builder.id;
        eventName=builder.eventName;
        venue=builder.venue;
        date=builder.date;
        time=builder.time;
        comments=builder.comments;
        songs=builder.songs;
        
    }


    public Long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getVenue() {
        return venue;
    }
    
      public Date getDate() {
        return date;
    }
    
    public Date getTime() {
        return time;
    }
    
    public String getComments() {
        return comments;
    
    }
    
    public List<Songs> getSongs() {
        return songs;
    }
    
   
    
    public static class Builder{
        
        private Long id;
        private String eventName;
        private String venue;
        private Date date;
        private Date time;
        private String comments;
        private List<Songs> songs;
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }


        public Builder(String name) {
            this.eventName = name;
        }

        public Builder venue(String value){
            this.venue=value;
            return this;
        }
        
         public Builder time(Date value) {
            this.time=value;
            return this;
        }
        
      
        
        public Builder comments(String value){
            this.comments=value;
            return this;
        }
        
         public Builder songs(List<Songs> value){
            this.songs=value;
            return this;
        }
         
        public Builder copy(Event value)
        {
        this.id = value.getId();
        this.eventName = value.getEventName();
        this.comments = value.getVenue();
        this.songs = value.getSongs();
        this.date = value.getDate();
        this.time = value.getTime();
        this.venue = value.getVenue();
                
        return this;
        }
        
        public Event build(){
            return new Event(this);
        }

        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        return !(id != null ? id.equals(event.id) : event.id == 0);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", Event Name='" + eventName + '\'' +
                '}';
    }
   
}
