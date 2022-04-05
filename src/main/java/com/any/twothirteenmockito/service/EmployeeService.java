package com.any.twothirteenmockito.service;

import java.util.Collection;

import com.any.twothirteenmockito.model.Employee;

public interface EmployeeService {

    Employee addEmployee(String firstName, String secondName, Integer department, Float salary);

    Employee removeEmployee(String firstName, String secondName);

    Employee findEmployee(String firstName, String secondName);

    Collection<Employee> getAllEmployee();

}
