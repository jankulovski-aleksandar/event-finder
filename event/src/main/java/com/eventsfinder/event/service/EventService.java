package com.eventsfinder.event.service;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.model.Comment;
import com.eventsfinder.event.domain.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    void addComment(Long eventId, Comment comment);
    void editEvent(Long eventId, Event event);
    //List<Event> findAllByLocationId(Long locationId);
    List<Event> findAll();

    Event save(Event event);

    Optional<Event> findById(Long id);

    void delete(Event event);

    void deleteById(Long id);
    List<Event> findByCategory(Category category);
    List<Event> findAllByCountry(String country);
    List<Event> findAllByCity(String city);
    List<Event> findAllByAddress(String address);

}
