package com.example.simple.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.simple.Entity.Task;
import com.example.simple.Repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taRepo;

    public Task addTask(Task ta) {
        return taRepo.save(ta);
    }

    public List<Task> getTasks() {
        return taRepo.findAll();
    }

    public Task updateTask(Long id, Task ta) {
        ta.setId(id);
        return taRepo.save(ta);
    }

    public String deleteTask(Long id) {
        taRepo.deleteById(id);
        return "Success";
    }

    public Page<Task> getTaskByPage(int page, int size) {
        return taRepo.findAll(PageRequest.of(page, size));
    }

    public List<Task> sortByTasks() {
        return taRepo.findAll(Sort.by(Sort.Direction.ASC, "taskname"));
    }

    public List<Task> getByQuery(String name) {
        return taRepo.findByTaskname(name);
    }

    public List<Task> getByTaskname(String taskname) {
        return taRepo.findBytaskname(taskname);
    }
}
