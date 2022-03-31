package com.any.twothirteenmockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentService.maxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping(path = "/average-salary")
    public Employee averageSalary(@RequestParam int departmentId) {
        return departmentService.averageSalary(departmentId);
    }

    @GetMapping(path = "/sum-salary")
    public Employee sumSalary(@RequestParam int departmentId) {
        return departmentService.sumSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allElmployeeNames() {
        return departmentService.allEmployeeNames();
    }

    @GetMapping(path = "/all-by-department")
    public Collection<Employee> allEmployeeByDepartment(@RequestParam int departmentId) {
        return departmentService.allEmployeeByDepartment(departmentId);
    }

}
