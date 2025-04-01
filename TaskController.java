package com.example.simple.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.simple.Entity.Task;
import com.example.simple.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taService;

    @PostMapping("/add")
    public Task insertTask(@RequestBody Task ta) {
        return taService.addTask(ta);
    }

    @GetMapping("/get")
    public List<Task> getAllTasks() {
        return taService.getTasks();
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task ta) {
        return taService.updateTask(id, ta);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taService.deleteTask(id);
    }

    @GetMapping("/page")
    public Page<Task> getByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "7") int size) {
        return taService.getTaskByPage(page, size);
    }

    @GetMapping("/sort")
    public List<Task> sortByTasks() {
        return taService.sortByTasks();
    }

    @GetMapping("/p/{name}")
    public List<Task> getTaskname(@PathVariable String name) {
        return taService.getByQuery(name);
    }

    @GetMapping("/custom/{taskname}")
    public List<Task> findByTaskname(@PathVariable String taskname) {
        return taService.getByTaskname(taskname);
    }
}
