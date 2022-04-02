package com.any.twothirteenmockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeService employeeService;
    private Employee employee;
@BeforeEach
    public void setUp() {
        employee = new Employee("Popov", 800,250_000);
    }

    @Test
    public void getAllEmployees() {
        assertNotNull(employee); // проверка, что список сотрудников не пустой
        employeeService.add("Popov", 800,250_000);
        Collection<Employee> expected = employeeService.getAll();
        when(employeeService.getAll()).thenReturn((Collection<Employee>) employee);
    }
    @Test
    public void addEmployee() {
        Collection<Employee> expected = employeeService.getAll();
        when(employeeService.add("Popov", 800,250_000)).thenReturn((employee));
    }
    @Test
    public void removeEmployee() {
        when(employeeService.remove("Popov", 800,250_000)).thenReturn((employee));
    }
    @Test
    public void findEmployee() {
        when(employeeService.remove("Popov", 800,250_000)).thenReturn((employee));
    }
}
