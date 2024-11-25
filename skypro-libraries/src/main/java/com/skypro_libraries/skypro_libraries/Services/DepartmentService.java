package com.skypro_libraries.skypro_libraries.Services;

import com.skypro_libraries.skypro_libraries.Domain.Employee;
import com.skypro_libraries.skypro_libraries.Exceptions.EmptyMapException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findMinSalaryByDepartment(int departmentNumber) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentNumber() == departmentNumber)
                .min(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(() -> new EmptyMapException("No such employee"));
    }

    public Employee findMaxSalaryByDepartment(int departmentNumber) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentNumber() == departmentNumber)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(() -> new EmptyMapException("No such employee"));
    }

    public List<Employee> getAllEmployeesByDepartment(int departmentNumber) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentNumber() == departmentNumber)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployeeSortedByDepartment() {
        return employeeService.getAll().stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartmentNumber()))
                .collect(Collectors.toList());
    }
}
