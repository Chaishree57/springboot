package com.example.simple.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.simple.Entity.Event;
import com.example.simple.Entity.Guest;
import com.example.simple.Entity.Task;
import com.example.simple.Repository.EventRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository evRepo;

    public Event addEvent(Event event) {
        if (event.getTasks() != null) {
            for (Task task : event.getTasks()) {
                task.setEvent(event);
            }
        }
        if (event.getGuests() != null) {
            for (Guest guest : event.getGuests()) {
                guest.setEvent(event);
            }
        }
        return evRepo.save(event);
    }

    public List<Event> getEvents() {
        return evRepo.findAll();
    }

    public Event updateEvent(Long id, Event event) {
        event.setId(id);
        if (event.getTasks() != null) {
            for (Task task : event.getTasks()) {
                task.setEvent(event);
            }
        }
        if (event.getGuests() != null) {
            for (Guest guest : event.getGuests()) {
                guest.setEvent(event);
            }
        }
        return evRepo.save(event);
    }

    public String deleteEvent(Long id) {
        evRepo.deleteById(id);
        return "Success";
    }

    public Page<Event> getEventByPage(int page, int size) {
        return evRepo.findAll(PageRequest.of(page, size));
    }

    public List<Event> sortByEvents() {
        return evRepo.findAll(Sort.by(Sort.Direction.ASC, "eventname"));
    }

    public List<Event> getByQuery(String name) {
        return evRepo.findByEventname(name);
    }

    public List<Event> getByEventname(String eventname) {
        return evRepo.findByEventname(eventname);
    }
}
