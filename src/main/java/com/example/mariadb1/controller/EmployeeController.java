package com.example.mariadb1.controller;


import com.example.mariadb1.model.Employee;
import com.example.mariadb1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    //create employee
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/fetch/all")
    //read employee
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/fetch/{id}")
    //get employee by id
    public Employee createEmployeeById(@PathVariable("id") Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    //update employee
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    //delete employee
    public void deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
    }



}
