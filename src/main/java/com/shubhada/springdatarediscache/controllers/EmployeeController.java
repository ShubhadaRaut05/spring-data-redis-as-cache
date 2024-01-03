package com.shubhada.springdatarediscache.controllers;

import com.shubhada.springdatarediscache.models.Employee;
import com.shubhada.springdatarediscache.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") int id){

        return employeeService.findById(id);
    }
    @PutMapping("/employees")
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }
    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }

}
