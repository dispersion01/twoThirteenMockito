package com.any.twothirteenmockito;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.springframework.util.StringUtils.capitalize;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final List<Employee> employeesList;

    public EmployeeServiceImpl() {
        employeesList = new ArrayList<>();
    }

    @Override
    public Collection<Employee> getAll() {
        return List.copyOf(employeesList);
    }

    @Override
    public Employee add(String familyName, int department, int salary) {
        validateNames(familyName);
        Employee newElement = new Employee(capitalize(familyName), department, salary);
        if (newElement.equals(employeesList.contains(familyName))) {
            throw new RuntimeException("Сотрудник уже существует");
        }
        employeesList.add(newElement);
        return newElement;
    }


    public Employee remove(String familyName, int department, int salary) {
        Employee removeElement = new Employee(familyName, department, salary);
        if (employeesList.contains(removeElement)) {
            employeesList.remove(removeElement);
        }
        throw new RuntimeException();

    }

    public Employee find(String familyName, int department, int salary) {
        Employee findElement = new Employee(familyName, department, salary);
        if (employeesList.contains(findElement)) {
            return findElement;
        }
        return findElement;
    }

    public void validateNames(String... name) {
        for (String names : name) {
            if (!isAlpha(names)) {
                throw new RuntimeException();
            }
        }
    }
}