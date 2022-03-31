package com.any.twothirteenmockito;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    //    решение через Map

    private EmployeeServiceImpl departmentService;

    public DepartmentServiceImpl(EmployeeServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    public Employee maxSalary(int departmentId) {
        return departmentService.getAll().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }


    public Employee minSalary(int departmentId) {
        return departmentService.getAll().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }


    @Override
    public Employee averageSalary(int departmentId) {
        return null;

    }

    @Override
    public Employee sumSalary(int departmentId) {
        return null;
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeeNames() {
        return departmentService.getAll().stream()
                .sorted(Comparator.comparing(Employee::getFamilyName).thenComparing(Employee::getDepartment))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }


    public Collection<Employee> allEmployeeByDepartment(int departmentId) {
        return departmentService.getAll().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }


}

