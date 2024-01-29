package com.restapi.exerciseemployees.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.restapi.exerciseemployees.model.Employee;

@Repository
public class EmployeeRepository {

    List<Employee> listEmployee = new ArrayList<>();

    public Employee saveEmployee(Employee employee){

        Employee employee1 = new Employee();

        employee1.setId(employee.getId());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setAge(employee.getAge());
        employee1.setEmail(employee.getEmail());
        employee1.setPhone(employee.getPhone());
        employee1.setSalary(employee.getSalary());
        employee1.setYearsOfExperience(employee.getYearsOfExperience());

        listEmployee.add(employee1);
        return employee1;
    }


    public List<Employee> getAllEmployees(){
        return listEmployee;
    }


    public Employee getEmployee(String id){
        Optional<Employee> responseEmployee = listEmployee
            .stream().filter(employee -> employee.getId().equals(id)).findFirst();
        
        return (Employee) responseEmployee.orElse(null);
    }


    public Employee updateEmployee(Employee employee){        

        listEmployee.removeIf(findEmployee -> findEmployee.getId().equals(employee.getId()));
        listEmployee.add(employee);
        return employee;        
    }


    public void deleteEmployeeById(String id){

        listEmployee.removeIf(employee -> employee.getId().equals(id));
    }


    public Employee findEmployeeByEmail(String email){
     
        Optional<Employee> responseEmployee = listEmployee.stream()
                .filter(employee -> employee.getEmail().equals(email))
                .findFirst();
        
        return responseEmployee.orElse(null);
    } 


    public List<Employee> salaryGreaterThan1000(){
        return listEmployee.stream()
                .filter(employee -> Integer.parseInt(employee.getSalary()) > 1000)
                .collect(Collectors.toList());
    }


    public List<Employee> experienceGreaterThan5(){
        return listEmployee.stream()
                .filter(employee -> 
                Integer.parseInt(employee.getYearsOfExperience()) > 5)
                .collect(Collectors.toList());
    }
    
}
