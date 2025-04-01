package com.example.simple.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.simple.Entity.Guest;
import com.example.simple.Service.GuestService;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guService;

    @PostMapping("/add")
    public Guest insertGuest(@RequestBody Guest gu) {
        return guService.addGuest(gu);
    }

    @GetMapping("/get")
    public List<Guest> getAllGuests() {
        return guService.getGuests();
    }

    @PutMapping("/update/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest gu) {
        return guService.updateGuest(id, gu);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGuest(@PathVariable Long id) {
        return guService.deleteGuest(id);
    }

    @GetMapping("/page")
    public Page<Guest> getByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "7") int size) {
        return guService.getGuestByPage(page, size);
    }

    @GetMapping("/sort")
    public List<Guest> sortByGuests() {
        return guService.sortByGuests();
    }

    @GetMapping("/s/{name}")
    public List<Guest> getGuestname(@PathVariable String name) {
        return guService.getByQuery(name);
    }

    @GetMapping("/custom/{event}")
    public List<Guest> findByEvent(@PathVariable String event) {
        return guService.getByEvent(event);
    }
}
