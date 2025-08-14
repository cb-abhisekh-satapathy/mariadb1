package com.example.mariadb1.service;

import com.example.mariadb1.exception.EmployeeNotFoundException;
import com.example.mariadb1.model.Employee;
import com.example.mariadb1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Id not found!"));
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

}
