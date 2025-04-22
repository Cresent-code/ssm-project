package org.example.crudemployeemanage.service;

import org.example.crudemployeemanage.bean.Employee;

import java.util.List;

public interface EmployeeService {
    //根据id查询员工
    Employee getEmployeeById(Integer id);

    //通过name查询员工
    Employee getEmployeeByName(String empName);

    //查询全部员工
    List<Employee> getEmployees();

    //增加员工
    void insertEmployee(Employee employee);

    //更新员工
    void updateEmployee(Employee employee);

    //删除员工
    void deleteEmployee(Integer id);
}
