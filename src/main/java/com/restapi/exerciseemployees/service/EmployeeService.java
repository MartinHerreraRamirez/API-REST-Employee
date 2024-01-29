package com.restapi.exerciseemployees.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.exerciseemployees.model.Employee;
import com.restapi.exerciseemployees.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){

        return employeeRepository.saveEmployee(employee);
    }

    public Employee getEmployee(String id){

        return employeeRepository.getEmployee(id);
    }

    public List<Employee> getAllEmployees(){

        return employeeRepository.getAllEmployees();
    }

    public Employee updateEmployee(Employee employee){

        return employeeRepository.updateEmployee(employee);
    }

    public void deleteEmployee(String id){

        employeeRepository.deleteEmployeeById(id);
    }

    public Employee findEmployeeByEmail(String email){

        return employeeRepository.findEmployeeByEmail(email);
    }

    public List<Employee> salaryGreaterThan1000(){

        return employeeRepository.salaryGreaterThan1000();
    }

    public List<Employee> experienceGreaterThan5(){

        return employeeRepository.experienceGreaterThan5();
    }
    
}
