package com.eventsfinder.event.repository;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.model.Comment;
import com.eventsfinder.event.domain.model.Event;
import com.eventsfinder.event.domain.model.EventInformation;
import com.eventsfinder.event.domain.valueobjects.Location;
import net.bytebuddy.matcher.FilterableList;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    private final EventRepository eventRepository;

    public DataHolder(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @PostConstruct
    public void init(){
        List<Event> eventList=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            if(i%2==0) {
                eventList.add(new Event((long) (i + 1), true, true, "invalid", Category.THEATER, "Joco" + i + 1, "Joco" + i + 1, new EventInformation(), new ArrayList<Comment>(), new Location((long) i, "Country" + i + 1, "City" + i + 1, "Address" + i + 1, 20 + i, 25 + i, "Location" + i + 1, "Link" + i + 1)));
            } else{
                eventList.add(new Event((long) (i+1),true,true,"valid", Category.CONCERT,"Joco"+i+1,"Joco"+i+1,new EventInformation(),new ArrayList<Comment>(),new Location((long) i,"Country"+i+1,"City"+i+1,"Address"+i+1,20+i,25+i,"Location"+i+1,"Link"+i+1)));
            }
        }
        this.eventRepository.saveAll(eventList);
    }
}
