package com.example.simple.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.simple.Entity.Event;
import com.example.simple.Service.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService evService;

    @PostMapping("/addevent")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event savedEvent = evService.addEvent(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Event> getAllEvents() {
        return evService.getEvents();
    }

    @PutMapping("/update/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event ev) {
        return evService.updateEvent(id, ev);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return evService.deleteEvent(id);
    }

    @GetMapping("/page")
    public Page<Event> getEventsByPage(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "7") int size) {
        return evService.getEventByPage(page, size);
    }

    @GetMapping("/sort")
    public List<Event> sortByEvents() {
        return evService.sortByEvents();
    }

    @GetMapping("/r/{name}")
    public List<Event> getEventname(@PathVariable String name) {
        return evService.getByQuery(name);
    }
}
