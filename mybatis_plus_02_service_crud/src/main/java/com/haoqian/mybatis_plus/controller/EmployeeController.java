package com.haoqian.mybatis_plus.controller;

import com.haoqian.mybatis_plus.entity.Employee;
import com.haoqian.mybatis_plus.service.EmployeeService;
import com.haoqian.mybatis_plus.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author haoqian
 * @since 2020-12-20
 */
@RestController
@RequestMapping("/mymodule/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeService.list(null);
    }

    @GetMapping("/list2")
    public List<Employee> list2() {
        return employeeServiceImpl.list(null);
    }

    @GetMapping("/selectById/{id}")
    public Employee selectById(@PathVariable("id") Long id) {
        return employeeServiceImpl.selectById(id);
    }
}

