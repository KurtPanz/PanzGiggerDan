package panzgiggerdan.repository;

import panzgiggerdan.domain.Event;
import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository<Event,Long>{
    public Event findByEventName(String eventName);

}
