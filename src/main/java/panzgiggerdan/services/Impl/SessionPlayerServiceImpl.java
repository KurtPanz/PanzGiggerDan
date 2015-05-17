package panzgiggerdan.services.Impl;

import panzgiggerdan.domain.SessionPlayer;
import panzgiggerdan.repository.SessionPlayerRepository;
import panzgiggerdan.servicess.SessionPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Service
public class SessionPlayerServiceImpl  implements SessionPlayerService{
    @Autowired
    SessionPlayerRepository repository;
    public List<SessionPlayer> getSessionPlayers() {
        List<SessionPlayer> allsessionplayers = new ArrayList<SessionPlayer>();

        Iterable<SessionPlayer> sessionplayers = repository.findAll();
        for (SessionPlayer sessionplayer : sessionplayers) {
            allsessionplayers.add(sessionplayer);
        }
        return allsessionplayers;
    }
}
