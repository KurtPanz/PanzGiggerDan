package panzgiggerdan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
public class Songs implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String songName;
    private String artistName;
    private String keyScale;
    private String progression;
    private String lyrics;
    private String comments; 
    
    private Songs() {
    }
 
    
    public Songs(Builder builder){
        songName=builder.songName;
        artistName=builder.artistName;
        keyScale=builder.keyScale;
        progression=builder.progression;
        lyrics=builder.lyrics;
        comments=builder.comments;
        
    }
   
    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }
    
     public String getKeyScale() {
        return keyScale;
    }

    public String getProgression() {
        return progression;
    }
    
     public String getLyrics() {
        return lyrics;
    }

    public String getComments() {
        return comments;
    }

   

    public static class Builder{
        
        private String songName;
        private String artistName;
        private String keyScale;
        private String progression;
        private String lyrics;
        private String comments; 
        

        public Builder(String name) {
            this.songName = name;
        }

        public Builder artistName(String value){
            this.artistName=value;
            return this;
        }
        
        public Builder keyScale(String value){
            this.keyScale=keyScale;
            return this;
        }
        public Builder progression(String value){
            this.progression=progression;
            return this;
        }
        public Builder lyrics(String value){
            this.lyrics=value;
            return this;
        }
        public Builder comments(String value){
            this.comments=value;
            return this;
        }
        
        public Builder copy(Songs value)
        {
           this.songName = value.getSongName();
           this.artistName = value.getArtistName();
           this.keyScale = value.getKeyScale();
           this.progression = value.getProgression();
           this.lyrics = value.getLyrics();
           this.comments = value.getComments(); 
           return this;
        }
        
        public Songs build(){
            return new Songs(this);
        }
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Songs song = (Songs) o;

        return !(id != null ? id.equals(song.id) : song.id == 0);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", Song Name='" + songName + '\'' +
                '}';
    }
   

}
