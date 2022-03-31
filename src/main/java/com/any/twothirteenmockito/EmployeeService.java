package com.any.twothirteenmockito;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee add(String familyName, int department, int salary);

    Employee remove(String familyName, int department, int salary);

    Employee find(String familyName, int department, int salary);

    Collection<Employee> getAll();
}
