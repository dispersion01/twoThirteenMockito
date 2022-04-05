package com.any.twothirteenmockito.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.any.twothirteenmockito.model.Employee;

public interface DepartmentService {

    Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId);

    Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId);

    Collection<Employee> findAllEmployeeByDepartmentId(int departmentId);

    Map<Integer, List<Employee>> findAllEmployeeByDepartmentId();

}
