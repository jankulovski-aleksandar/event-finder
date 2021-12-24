package com.eventsfinder.event.domain.exceptions;

public class EventNotFoundedException extends RuntimeException{
public  EventNotFoundedException(Long id) {
    super(String.format("Event with id %d doesn't exists",id));
    }
}
