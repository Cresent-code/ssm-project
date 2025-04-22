package org.example.crudemployeemanage.service.impl;

import org.example.crudemployeemanage.bean.Employee;
import org.example.crudemployeemanage.dao.EmpMapper;
import org.example.crudemployeemanage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public Employee getEmployeeById(Integer id) {
        return empMapper.getEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByName(String empName) {
        return empMapper.getEmployeeByName(empName);
    }

    @Override
    public List<Employee> getEmployees() {
        return empMapper.getEmployees();
    }

    @Override
    public void insertEmployee(Employee employee) {
        empMapper.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        empMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        empMapper.deleteEmployee(id);
    }
}

