package com.example.simple.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.simple.Entity.Guest;
import com.example.simple.Repository.GuestRepository;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guRepo;

    public Guest addGuest(Guest gu) {
        return guRepo.save(gu);
    }

    public List<Guest> getGuests() {
        return guRepo.findAll();
    }

    public Guest updateGuest(Long id, Guest gu) {
        gu.setId(id);
        return guRepo.save(gu);
    }

    public String deleteGuest(Long id) {
        guRepo.deleteById(id);
        return "Success";
    }

    public Page<Guest> getGuestByPage(int page, int size) {
        return guRepo.findAll(PageRequest.of(page, size));
    }

    public List<Guest> sortByGuests() {
        return guRepo.findAll(Sort.by(Sort.Direction.ASC, "guestname"));
    }

    public List<Guest> getByQuery(String name) {
        return guRepo.findByEvent_Eventname(name);
    }

    public List<Guest> getByEvent(String eventname) {
        return guRepo.findByEvent_Eventname(eventname);
    }
}
