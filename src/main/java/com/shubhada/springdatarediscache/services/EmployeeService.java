package com.shubhada.springdatarediscache.services;

import com.shubhada.springdatarediscache.exceptions.ResourceNotFoundException;
import com.shubhada.springdatarediscache.models.Employee;
import com.shubhada.springdatarediscache.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee) {
         return employeeRepository.save(employee);

    }
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) throws ResourceNotFoundException {
        System.out.println("employee fetching from database with id ::"+id);
        return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id)));
    }

    public Employee update(Employee employee,int id) throws ResourceNotFoundException {

        Employee emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with this id: "+id));
        emp.setName(employee.getName());
        Employee updatedEmployee=employeeRepository.save(emp);
        return updatedEmployee;
    }

    public void delete(int id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found " + id));
        employeeRepository.delete(employee);
    }
}
