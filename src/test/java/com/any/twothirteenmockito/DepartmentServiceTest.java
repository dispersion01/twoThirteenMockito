package com.any.twothirteenmockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl employeeDepartment;

    private Employee MAX_SALARY = new Employee("Ivanov", 01, 300_000);
    private Employee MIN_SALARY = new Employee("Petrov", 06, 100_000);
    private Employee SUM_SALARY = new Employee("Popov", 06, 400_000);
    private String FAMILY_NAME = "Ivanov";
    private int DEPARTMENT = 60;
    private int SALARY = 60_000;
    private Set<Employee> DEPARTMENT_EMPLOYEES = Set.of();
    private Collection<Employee> EMPLOYEE = Set.of(MAX_SALARY, MIN_SALARY);
    private int DEPARTMENT_ID = 80;


    @Test
    public void shouldReturnMaxSalaryByDepartments(x
                                                   ) {
        when(employeeService.getAll()).thenReturn(EMPLOYEE);
        assertEquals(MAX_SALARY, employeeDepartment.maxSalary(DEPARTMENT_ID));
    }

    @Test
    public void souldReturnMinSalaryByDepartments() {
        when(employeeService.getAll()).thenReturn(EMPLOYEE);
        assertEquals(MIN_SALARY, employeeDepartment.minSalary(DEPARTMENT_ID));

    }

    @Test
    public void shouldReturnEmployeeExist() {
//        Employee exist = employeeService.add(FAMILY_NAME, DEPARTMENT, SALARY);
//        assertEquals(exist, employeeDepartment.allEmployeeByDepartment(DEPARTMENT_ID));
        when(employeeDepartment.getALL()).thenReturn()
    }



}
