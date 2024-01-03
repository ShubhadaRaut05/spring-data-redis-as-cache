package com.shubhada.springdatarediscache.services;

import com.shubhada.springdatarediscache.models.Employee;
import com.shubhada.springdatarediscache.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee) {
         employeeRepository.saveEmployee(employee);
         return employee;
    }
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    public void delete(int id) {
        employeeRepository.delete(id);
    }
}
