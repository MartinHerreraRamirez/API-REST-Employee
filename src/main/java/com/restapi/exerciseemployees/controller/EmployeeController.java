package com.restapi.exerciseemployees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.exerciseemployees.model.Employee;
import com.restapi.exerciseemployees.service.EmployeeService;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable String id){
        return (Employee) employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/email/{email}")
    public Employee findEmployeeByEmail(@PathVariable String email){

        return employeeService.findEmployeeByEmail(email);
    }

    @GetMapping("/salary")
    public List<Employee> salaryGreaterThan1000(){
        return employeeService.salaryGreaterThan1000();
    }

    @GetMapping("/experience")
    public List<Employee> experienceGreaterThan5(){
        return employeeService.experienceGreaterThan5();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return "Employee with id: " + id + " was deleted";
    }    
    
}
