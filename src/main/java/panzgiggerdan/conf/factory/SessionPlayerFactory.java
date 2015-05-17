package panzgiggerdan.conf.factory;

import panzgiggerdan.domain.SessionPlayer;


import java.util.Map;

public class SessionPlayerFactory {

    public static SessionPlayer createSessionPlayer(Map<String,String> values){
        SessionPlayer sessionPlayer = new SessionPlayer
                .Builder(values.get("userName"))
                .password(values.get("password"))                
                .build();
        
        return sessionPlayer;
    }
}
