package com.example.simple.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.simple.Entity.Guest;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    //@Query("SELECT g FROM Guest g WHERE g.guestname LIKE %:name%")
    //List<Guest> findByGuestname(@Param("name") String name);

    @Query("SELECT g FROM Guest g WHERE g.event.eventname = :eventname")
    List<Guest> findByEventName(@Param("eventname") String eventname);

    List<Guest> findByEvent_Eventname(String eventname);


}
