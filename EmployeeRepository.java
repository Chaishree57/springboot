package com.example.simple.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.simple.Entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.employeename LIKE %:name%")
    List<Employee> findByEmployeename(@Param("name") String name);

    List<Employee> findByTaskId(Long taskId);
}
