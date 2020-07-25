package com.management.service.impl;

import com.management.dao.EmployeeDao;
import com.management.model.Employee;
import com.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> findAll() {
        List<Employee> employees=null;
      employees=employeeDao.findAll();

        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee=null;
         employee = employeeDao.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public Integer addEmployee(Employee employee) {
        int start=0;
         start = employeeDao.insert(employee);
        return start;
    }

    @Override
    public Integer deleteEmployee(Integer id) {
        int start=0;
         start = employeeDao.deleteByPrimaryKey(id);
        return start;
    }

    @Override
    public Integer updateEmployee(Employee employee) {
        int start=0;
         start = employeeDao.updateByPrimaryKey(employee);
        return start;
    }


}
