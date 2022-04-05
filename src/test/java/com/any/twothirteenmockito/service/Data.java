package com.any.twothirteenmockito.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.any.twothirteenmockito.model.Employee;

import static java.util.stream.Collectors.groupingBy;

public class Data {
    public static final String FIRST_NAME = "Sergey";
    public static final String SECOND_NAME = "Kaplin";
    public static final String FIRST_NAME2 = "Anton";
    public static final String SECOND_NAME2 = "Alekseev";
    public static final int DEPARTMENT = 1;
    public static final int DEPARTMENT2 = 2;
    public static final Float SALARY = 50f;
    public static final Float SALARY2 = 100f;
    public static final Employee EMPLOYEE = new Employee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY);
    public static final Employee EMPLOYEE2 = new Employee(FIRST_NAME2, SECOND_NAME2, DEPARTMENT, SALARY2);
    public static final Set<Employee> EMPLOYEES = Set.of(EMPLOYEE, EMPLOYEE2);
    public static final Employee EMPLOYEE_DEPARTMENT2 = new Employee(FIRST_NAME2, SECOND_NAME2, DEPARTMENT2, SALARY);
    public static final Set<Employee> EMPLOYEES2 = Set.of(EMPLOYEE, EMPLOYEE_DEPARTMENT2);

    public static final Map<Integer, List<Employee>> DEPARTMENTS_MAP = EMPLOYEES2.stream()
            .collect(groupingBy(Employee::getDepartment));

}
