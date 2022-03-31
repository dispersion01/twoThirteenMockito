package com.any.twothirteenmockito;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(int departmentId);

    Employee minSalary(int departmentId);

    Employee averageSalary(int departmentId);

    Employee sumSalary(int departmenId);

    Map<Integer, List<Employee>> allEmployeeNames();

    Collection<Employee> allEmployeeByDepartment(int departmentId);

}
