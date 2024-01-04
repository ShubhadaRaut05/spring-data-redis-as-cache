package com.shubhada.springdatarediscache.controllers;

import com.shubhada.springdatarediscache.exceptions.ResourceNotFoundException;
import com.shubhada.springdatarediscache.models.Employee;
import com.shubhada.springdatarediscache.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){

        return ResponseEntity.ok(employeeService.findAll());
    }
    @GetMapping("/employees/{id}")
    @Cacheable(value="employees",key="#id")
    public Optional<Employee> findById(@PathVariable("id") int id) throws ResourceNotFoundException {
        try {
            return employeeService.findById(id);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/employees/{id}")
    @CachePut(value="employees",key="#id")
    public Employee update(@RequestBody Employee employee,@PathVariable int id) throws ResourceNotFoundException {

       return  employeeService.update(employee,id);
    }
    @DeleteMapping("/employees/{id}")
    @CacheEvict(value="employees",allEntries = true)
    public void delete(@PathVariable int id) throws ResourceNotFoundException {

        employeeService.delete(id);
    }

}
