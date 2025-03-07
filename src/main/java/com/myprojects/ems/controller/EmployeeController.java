package com.myprojects.ems.controller;

import com.myprojects.ems.exception.ResourceNotFoundException;
import com.myprojects.ems.model.Employee;
import com.myprojects.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    // get an employee
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable long employeeId){
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(String.format("employee with id: %s is not found!",employeeId)));
    }
}
