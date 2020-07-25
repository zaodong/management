package com.management.service;

import com.management.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer id);

    Integer addEmployee(Employee employee);

    Integer deleteEmployee(Integer id);

    Integer updateEmployee(Employee employee);
}
