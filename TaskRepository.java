package com.example.simple.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.simple.Entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.taskname LIKE %:name%")
    List<Task> findByTaskname(@Param("name") String name);

    List<Task> findBytaskname(String taskname);
}
