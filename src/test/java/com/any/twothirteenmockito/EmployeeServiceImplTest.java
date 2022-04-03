package com.any.twothirteenmockito;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private Employee MAX_SALARY = new Employee("Ivanov", 01, 300_000);
    private Employee MIN_SALARY = new Employee("Petrov", 06, 100_000);
    private Employee SUM_SALARY = new Employee("Popov", 06, 400_000);
    private String FAMILY_NAME = "Ivanov";
    private int DEPARTMENT = 60;
    private int SALARY = 60_000;
    private Set<Employee> DEPARTMENT_EMPLOYEES = Set.of();
    private Collection<Employee> EMPLOYEE = Set.of(MAX_SALARY, MIN_SALARY);

    private EmployeeServiceImpl employeeTest = new EmployeeServiceImpl();


    @Test
    public void shouldAdd() {
        Employee expect = employeeTest.add(FAMILY_NAME, DEPARTMENT, SALARY);
        assertEquals(0, employeeTest.getAll().size());
        assertFalse(employeeTest.getAll().contains(expect));
        Employee newEmployee = new Employee(FAMILY_NAME, DEPARTMENT, SALARY);
        assertEquals(expect, newEmployee);
        assertEquals(1, employeeTest.getAll().size());
        assertTrue(employeeTest.getAll().contains(expect));
    }

    @Test
    void shouldRemove() {
        Employee expect = employeeTest.add(FAMILY_NAME, DEPARTMENT, SALARY);
        assertEquals(1, employeeTest.getAll().size());
        assertTrue(employeeTest.getAll().contains(expect));
        Employee removedEmployee =employeeTest.remove(FAMILY_NAME,DEPARTMENT,SALARY);
        assertEquals(removedEmployee,expect);
        assertTrue(employeeTest.getAll().isEmpty());
        assertFalse(employeeTest.getAll().contains(expect));
    }

    @Test
    void shouldFind() {
        Employee addEmployee = employeeTest.add(FAMILY_NAME, DEPARTMENT, SALARY);
        assertEquals(addEmployee, employeeTest.find(FAMILY_NAME, DEPARTMENT, SALARY));
    }


}