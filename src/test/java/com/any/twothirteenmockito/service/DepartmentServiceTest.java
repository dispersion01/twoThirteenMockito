package com.any.twothirteenmockito.service;

import com.any.twothirteenmockito.exceptions.EmployeeNotFoundException;
import com.any.twothirteenmockito.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.any.twothirteenmockito.service.Data.DEPARTMENT;
import static com.any.twothirteenmockito.service.Data.DEPARTMENT2;
import static com.any.twothirteenmockito.service.Data.DEPARTMENTS_MAP;
import static com.any.twothirteenmockito.service.Data.EMPLOYEE;
import static com.any.twothirteenmockito.service.Data.EMPLOYEE2;
import static com.any.twothirteenmockito.service.Data.EMPLOYEES;
import static com.any.twothirteenmockito.service.Data.EMPLOYEES2;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentId() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE2, out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentIdWithNotFoundException() {
        when(employeeService.getAllEmployee()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentIdWithNotFoundExceptionWithBadDepartment() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT2));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE, out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentIdWithNotFoundException() {
        when(employeeService.getAllEmployee()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentIdWithNotFoundExceptionWithBadDepartment() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT2));
    }

    @Test
    public void findAllEmployeeByDepartmentId() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES2);
        assertEquals(DEPARTMENTS_MAP, out.findAllEmployeeByDepartmentId());
    }


}
