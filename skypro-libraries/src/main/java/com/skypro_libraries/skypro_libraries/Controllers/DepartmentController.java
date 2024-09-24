package com.skypro_libraries.skypro_libraries.Controllers;

import com.skypro_libraries.skypro_libraries.Domain.Employee;
import com.skypro_libraries.skypro_libraries.Services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee getMaxSalaryByDepartment(@RequestParam("departmentId") int e) {
        return departmentService.findMaxSalaryByDepartment(e);
    }

    @GetMapping(path = "/min-salary")
    public Employee getMinSalaryByDepartment(@RequestParam("departmentId") int e) {
        return departmentService.findMinSalaryByDepartment(e);
    }

    @GetMapping(path = "/all-by-department")
    public List<Employee> getAllEmployeesByDepartment(@RequestParam("departmentId") int e) {
        return departmentService.getAllEmployeesByDepartment(e);
    }

    @GetMapping(path = "/all")
    public List<Employee> getAllEmployees() {
        return departmentService.getAllEmployeeSortedByDepartment();
    }

}
