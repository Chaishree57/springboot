package com.example.simple.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.simple.Entity.Employee;
import com.example.simple.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService emService;

    @PostMapping("/add")
    public Employee insertEmployee(@RequestBody Employee em) {
        return emService.addEmployee(em);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployees() {
        return emService.getEmployees();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee em) {
        return emService.updateEmployee(id, em);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return emService.deleteEmployee(id);
    }

    @GetMapping("/page")
    public Page<Employee> getByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "7") int size) {
        return emService.getEmployeeByPage(page, size);
    }

    @GetMapping("/sort")
    public List<Employee> sortByEmployees() {
        return emService.sortByEmployees();
    }

    @GetMapping("/q/{name}")
    public List<Employee> getEmployeename(@PathVariable String name) {
        return emService.getByQuery(name);
    }

    @GetMapping("/task/{taskId}")
    public List<Employee> getEmployeesByTask(@PathVariable Long taskId) {
        return emService.getEmployeesByTaskId(taskId);
    }
}
