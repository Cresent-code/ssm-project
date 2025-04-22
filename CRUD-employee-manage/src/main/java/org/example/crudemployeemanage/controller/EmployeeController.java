package org.example.crudemployeemanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import jakarta.validation.Valid;
import org.example.crudemployeemanage.bean.Employee;
import org.example.crudemployeemanage.common.R;
import org.example.crudemployeemanage.exception.BizExceptionEnume;
import org.example.crudemployeemanage.exception.BizeException;
import org.example.crudemployeemanage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin//允许跨域
@RequestMapping("/api/v1")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PageInterceptor pageInterceptor;

    //根据id查询
    @RequestMapping(value = "/getEmployeeById/{id}", method = GET)
    public R getEmployeeById(@PathVariable Integer id) {
        if (id == null) {
            throw new BizeException(BizExceptionEnume.ID_NULL);
        }
        Employee emp = employeeService.getEmployeeById(id);
        return R.ok(emp);
    }

    //根据name查询
    @RequestMapping(value = "/getEmployeeByName/{name}", method = GET)
    public R getEmployeeByName(@PathVariable String name) {
        if (name == null) {
            throw new BizeException(BizExceptionEnume.NAME_NULL);
        }
        Employee emp = employeeService.getEmployeeByName(name);
        return R.ok(emp);
    }

    //查询全部数据
    @RequestMapping(value = "/employees", method = GET)
    public R getEmployees() {
        List emp = employeeService.getEmployees();
        return R.ok(emp);
    }
    //分页查询
    @RequestMapping(value = "/employee/page", method = GET)
    public R getEmployeePage(@RequestParam Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List emp = employeeService.getEmployees();
        PageInfo<Employee> info = new PageInfo<>(emp);
        return R.ok(emp);
    }

    //新增数据
    @RequestMapping(value = "/employee", method = POST)
    public R insertEmployee(@RequestBody @Valid Employee employee, BindingResult result) {
        if (!result.hasErrors()) {
            employeeService.insertEmployee(employee);
            return R.ok();
        }
        Map<String, String> errorsMap = new HashMap<>();
        for (FieldError fieldError : result.getFieldErrors()) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errorsMap.put(field, message);
        }
        return R.error(500, "校验失败",errorsMap);

    }

    //修改数据
    @RequestMapping(value = "/employee", method = PUT)
    public R updateEmployee(@RequestBody @Valid Employee employee, BindingResult result) {
        if (!result.hasErrors()) {
            employeeService.updateEmployee(employee);
            return R.ok();
        }
        Map<String, String> errorsMap = new HashMap<>();
        for (FieldError fieldError : result.getFieldErrors()) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errorsMap.put(field, message);
        }
        return R.error(500, "校验失败",errorsMap);
    }

    //删除数据
    @RequestMapping(value = "/employee/{id}", method = DELETE)
    public R deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return R.ok();
    }
}
