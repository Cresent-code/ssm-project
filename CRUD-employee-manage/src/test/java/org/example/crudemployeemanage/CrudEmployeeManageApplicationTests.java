package org.example.crudemployeemanage;

import org.example.crudemployeemanage.bean.Employee;
import org.example.crudemployeemanage.dao.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CrudEmployeeManageApplicationTests {
    @Autowired
    EmpMapper empMapper;

    @Test
    void testdeleteEmployee() {
        empMapper.deleteEmployee(6);
        System.out.println("ok");
    }

    @Test
    void testupdateEmployee() {
        Employee employee = new Employee();
        employee.setAge(26);
        employee.setId(7);
        empMapper.updateEmployee(employee);
        System.out.println("ok");
    }

    @Test
    void testinsertEmployee() {
        Employee employee = new Employee();
        employee.setName("李阿虎");
        employee.setEmail("123@qq.com");
        employee.setAddress("西安市高新区");
        employee.setGender("男");
        employee.setSalary(new BigDecimal("10000"));
        empMapper.insertEmployee(employee);
        System.out.println("ok");
    }

    @Test
    void testgetEmployeeById() {
        Employee employee = empMapper.getEmployeeById(1);
        System.out.println(employee);
    }

}
