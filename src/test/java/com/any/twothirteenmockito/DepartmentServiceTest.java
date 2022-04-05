package com.any.twothirteenmockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl employeeDepartment;

    private static String FIRST_FAMILY_NAME = "Ivanov";
    private static String SECOND_FAMILY_NAME = "Petrov";
    private static int FIRST_DEPARTMENT = 60;
    private static int SECOND_DEPARTMENT = 6;
    private static int SALARY_MIN = 60_000;
    private static int SALARY_MAX = 600_000;
    private static Employee MIN_SALARY = new Employee(FIRST_FAMILY_NAME, FIRST_DEPARTMENT, SALARY_MIN);
    private static Employee MAX_SALARY = new Employee(SECOND_FAMILY_NAME, SECOND_DEPARTMENT,SALARY_MAX);
    private static Set<Employee> DEPARTMENT_EMPLOYEES = Set.of();
    private static Set<Employee> EMPLOYEE = Set.of(MAX_SALARY, MIN_SALARY);
    private static int DEPARTMENT_ID = 60;


    @Test
    public void shouldReturnMaxSalaryByDepartments() {
        when(employeeService.getAll()).thenReturn(EMPLOYEE);
        assertEquals(MAX_SALARY, employeeDepartment.maxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnMinSalaryByDepartments() {
        when(employeeService.getAll()).thenReturn(EMPLOYEE);
        assertEquals(MIN_SALARY, employeeDepartment.minSalary(DEPARTMENT_ID));

    }









}
