package com.example.simple.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.simple.Entity.Employee;
import com.example.simple.Repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository emRepo;

    public Employee addEmployee(Employee em) {
        return emRepo.save(em);
    }

    public List<Employee> getEmployees() {
        return emRepo.findAll();
    }

    public Employee updateEmployee(Long id, Employee em) {
        em.setId(id);
        return emRepo.save(em);
    }

    public String deleteEmployee(Long id) {
        emRepo.deleteById(id);
        return "Success";
    }

    public Page<Employee> getEmployeeByPage(int page, int size) {
        return emRepo.findAll(PageRequest.of(page, size));
    }

    public List<Employee> sortByEmployees() {
        return emRepo.findAll(Sort.by(Sort.Direction.ASC, "employeename"));
    }

    public List<Employee> getByQuery(String name) {
        return emRepo.findByEmployeename(name);
    }

    public List<Employee> getByTaskId(Long taskId) {
        return emRepo.findByTaskId(taskId);
    }

    public List<Employee> getEmployeesByTaskId(Long taskId) {
       return emRepo. findByTaskId(taskId);
    }
}
