package com.eventsfinder.event.service.Impl;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.exceptions.EventNotFoundedException;
import com.eventsfinder.event.domain.model.Comment;
import com.eventsfinder.event.domain.model.Event;
import com.eventsfinder.event.repository.CommentRepository;
import com.eventsfinder.event.repository.EventRepository;
import com.eventsfinder.event.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;

    public EventServiceImpl(EventRepository eventRepository, CommentRepository commentRepository) {
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event save(Event entity) {
        return this.eventRepository.save(entity);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public void delete(Event entity) {
        this.eventRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findByCategory(Category category) {
       return this.eventRepository.findAllByCategory(category);
    }

    @Override
    public List<Event> findAllByCountry(String country) {
        return this.eventRepository.findAllByCountry(country);
    }

    @Override
    public List<Event> findAllByCity(String city) {
        return this.eventRepository.findAllByCity(city);

    }

    @Override
    public List<Event> findAllByAddress(String address) {
        return this.eventRepository.findAllByAddress(address);
    }

    @Override
    public void addComment(Long eventId,Comment comment) {
        if(this.findById(eventId).isPresent()) {
            Event event = this.findById(eventId).get();
            event.addComment(comment);
            this.commentRepository.save(comment);
            this.save(event);
        }
        else
            throw new EventNotFoundedException(eventId);
    }

    @Override
    public void editEvent(Long eventId, Event editedEvent) {
        this.save(editedEvent);
    }

}
