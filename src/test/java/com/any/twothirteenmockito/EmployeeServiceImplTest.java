package com.any.twothirteenmockito;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private static String FIRST_FAMILY_NAME = "Ivanov";
    private static int FIRST_DEPARTMENT = 60;
    private static int FIRST_SALARY = 60_000;
    private static int DEPARTMENT_ID = 60;

    private final EmployeeServiceImpl employeeTest = new EmployeeServiceImpl();


    @Test
    public void shouldAdd() {
        Employee expect = new Employee(FIRST_FAMILY_NAME, FIRST_DEPARTMENT, FIRST_SALARY);
        assertEquals(0, employeeTest.getAll().size());
        assertFalse(employeeTest.getAll().contains(expect));
        Employee newEmployee = employeeTest.add(FIRST_FAMILY_NAME, FIRST_DEPARTMENT, FIRST_SALARY);
        assertEquals(expect, newEmployee);
        assertEquals(1, employeeTest.getAll().size());
        assertTrue(employeeTest.getAll().contains(expect));
    }

    @Test
    void shouldRemove() {
        Employee expect = employeeTest.add(FIRST_FAMILY_NAME, FIRST_DEPARTMENT, FIRST_SALARY);
        assertEquals(1, employeeTest.getAll().size());
        assertTrue(employeeTest.getAll().contains(expect));
        Employee removedEmployee =employeeTest.remove(FIRST_FAMILY_NAME, FIRST_DEPARTMENT, FIRST_SALARY);
        assertEquals(removedEmployee,expect);
        assertTrue(employeeTest.getAll().isEmpty());
        assertFalse(employeeTest.getAll().contains(expect));
    }

    @Test
    public void shouldFindEmployeeIfExist() {
        employeeTest.add(FIRST_FAMILY_NAME, FIRST_DEPARTMENT, FIRST_SALARY);
        Employee exist = new Employee(FIRST_FAMILY_NAME, DEPARTMENT_ID, FIRST_SALARY);
                assertEquals(exist, employeeTest.find(FIRST_FAMILY_NAME, FIRST_DEPARTMENT, FIRST_SALARY));
    }


}