package com.any.twothirteenmockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collection;

import static org.mockito.Mockito.when;

public class DepartmentServiceTest {
    private final Employee employee = new Employee("Ivanov", 01, 300_000);
    private final Employee employeeOne = new Employee("Popov", 80, 250_000);
    private final Employee employeeTwo = new Employee("Petrov", 06, 100_000);
    private final Employee employeeThree = new Employee("Sidorov", 03, 150_000);
    private final Employee employeeFour = new Employee("Ivanov", 01, 300_000);

    DepartmentService departmentService;

    @Mock
    private EmployeeService employeeService;
    private Employee employeeDepartment;

    @BeforeEach
    public void setUp() {
        employeeDepartment = new Employee("Popov", 800, 250_000);
    }

    @Test
    public void maxSalaryByDepartments() {
        when(departmentService.maxSalary(800)).thenReturn((employeeDepartment));
    }
    @Test
    public void minSalaryByDepartments() {
        when(departmentService.minSalary(800)).thenReturn((employeeDepartment));
    }
    @Test
    public void averageSalaryByDepartments() {
        when(departmentService.averageSalary(800)).thenReturn((employeeDepartment));
    }
    @Test
    public void sumSalaryByDepartments() {
        when(departmentService.sumSalary(800)).thenReturn((employeeDepartment));
    }



}
