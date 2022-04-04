package com.any.twothirteenmockito.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.any.twothirteenmockito.exceptions.EmployeeNotFoundException;
import com.any.twothirteenmockito.model.Employee;
import com.any.twothirteenmockito.service.DepartmentService;
import com.any.twothirteenmockito.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployee().stream().
                filter(d -> d.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployee().stream().
                filter(d -> d.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findAllEmployeeByDepartmentId(int departmentId) {
        return employeeService.getAllEmployee().stream().
                filter(d -> d.getDepartment() == departmentId).
                collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeeByDepartmentId() {
        Map<Integer, List<Employee>> result = new HashMap<>();
        employeeService.getAllEmployee()
                .forEach(
                        e -> {
                            List<Employee> departmentEmployee = result.getOrDefault(e.getDepartment(),
                                    new ArrayList<Employee>());
                            departmentEmployee.add(e);
                            result.put(e.getDepartment(), departmentEmployee);
                        }
                );
        return result;

    }
}
