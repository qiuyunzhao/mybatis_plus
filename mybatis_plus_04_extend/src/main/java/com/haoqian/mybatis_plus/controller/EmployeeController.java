package com.haoqian.mybatis_plus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatis_plus.entity.Employee;
import com.haoqian.mybatis_plus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/selectByPage")
    public Page<Employee> selectByPage() {
        return employeeService.selectByPage();
    }


    @GetMapping("/deleteAll")
    public int deleteAll() {
        return employeeService.deleteAll();
    }

    @GetMapping("/updateById")
    public int updateById() {
        return employeeService.updateById();
    }

    @GetMapping("/logicDelete")
    public void logicDelete() {
        employeeService.logicDelete();
    }
}
