package com.any.twothirteenmockito.service;

import java.util.Collection;
import java.util.List;

import com.any.twothirteenmockito.exceptions.EmployeeExistsException;
import com.any.twothirteenmockito.exceptions.EmployeeNotFoundException;
import com.any.twothirteenmockito.model.Employee;
import com.any.twothirteenmockito.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import static com.any.twothirteenmockito.service.Data.DEPARTMENT;
import static com.any.twothirteenmockito.service.Data.EMPLOYEE;
import static com.any.twothirteenmockito.service.Data.FIRST_NAME;
import static com.any.twothirteenmockito.service.Data.SALARY;
import static com.any.twothirteenmockito.service.Data.SECOND_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeServiceTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void addEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getAllEmployee().size());
        Employee actual = out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY);
        assertEquals(EMPLOYEE, actual);
        assertEquals(1, out.getAllEmployee().size());
    }

    @Test
    public void addEmployeeWithExistsException() {
        Employee actual = out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY);
        assertTrue(out.getAllEmployee().contains(actual));
        assertEquals(1, out.getAllEmployee().size());
        assertThrows(EmployeeExistsException.class, () -> out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY));
    }

    @Test
    public void findEmployee() {
        out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY);
        Employee result = new Employee(FIRST_NAME, SECOND_NAME);
        assertEquals(result, out.findEmployee(FIRST_NAME, SECOND_NAME));
    }

    @Test
    public void findEmployeeWithNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(FIRST_NAME, SECOND_NAME));
    }

    @Test
    public void removeEmployee() {
        out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY);
        assertEquals(1, out.getAllEmployee().size());
        out.removeEmployee(FIRST_NAME, SECOND_NAME);
        assertThrows(EmployeeNotFoundException.class, () -> out.getAllEmployee().size());
    }

    @Test
    public void removeEmployeeWithNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(FIRST_NAME, SECOND_NAME));
    }


    @Test
    public void shouldReturnListOfEmployeesWhenTheyExist() {
        out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY);
        Collection<Employee> expected = List.of(EMPLOYEE);
        Collection<Employee> actual = out.getAllEmployee();
        assertIterableEquals(expected, actual);
    }
}
