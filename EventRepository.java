package com.example.simple.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.simple.Entity.Event;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.eventname LIKE %:name%")
    List<Event> findByEventnameContaining(@Param("name") String name);

    List<Event> findByEventname(String eventname);
}
