package com.restapi.exerciseemployees.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.restapi.exerciseemployees.model.Employee;

@Repository
public class EmployeeRepository {

    ArrayList<Employee> listEmployee = new ArrayList<>();

    public Employee saveEmployee(Employee employee){

        listEmployee.add(employee);
        return employee;
    }


    public ArrayList<Employee> getAllEmployees(){

        return listEmployee;
    }


    public Employee getEmployee(String id){

        return (Employee) listEmployee
                            .stream()
                            .filter(employee -> employee.getId().equals(id));
    }


    public Employee updateEmployee(Employee employee){

        String employeeId = employee.getId();

        for(int i = 0; i < listEmployee.size(); i++){

            if(listEmployee.get(i).getId() == employeeId){
                listEmployee.set(i, employee);
            }
        }

        return employee;
    }


    public String deleteEmployeeById(String id){

        listEmployee.removeIf(employee -> employee.getId() == id);
        return "employee was deleted";
    }


    public List<Employee> findEmployeeByEmail(String email){
     
        return listEmployee.stream()
                .filter(employee -> employee.getEmail().equals(email))
                .collect(Collectors.toList());
    } 


    public List<Employee> salaryGreaterThan1000(){
        return listEmployee.stream()
                .filter(employee -> Integer.parseInt(employee.getSalary()) > 1000)
                .collect(Collectors.toList());
    }


    public List<Employee> employeesExperienceGreaterThan5(){
        return listEmployee.stream()
                .filter(employee -> 
                Integer.parseInt(employee.getYearsOfExperience()) > 5)
                .collect(Collectors.toList());
    }
    
}
