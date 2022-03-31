package com.any.twothirteenmockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String helloEmployee() {
        return "Hello!";
    }

    @GetMapping("/add")
    public Employee addEmployeer(@RequestParam String familyName,
                                 @RequestParam int department,
                                 @RequestParam int salary) {
        return employeeService.add(familyName, department, salary);

    }

    @GetMapping("/remove")
    public Employee removeEmployeer(@RequestParam String familyName,
                                    @RequestParam int department,
                                    @RequestParam int salary) {
        return employeeService.remove(familyName, department, salary);

    }

    @GetMapping("/find")
    public Employee findEmployeer(@RequestParam String familyName,
                                  @RequestParam int department,
                                  @RequestParam int salary) {

        return employeeService.find(familyName, department, salary);
    }

}