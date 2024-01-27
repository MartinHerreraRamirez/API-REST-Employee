package com.restapi.exerciseemployees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private String salary;
    private String email;
    private String yearsOfExperience;
    private String phone;
    
}
