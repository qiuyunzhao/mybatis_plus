package com.haoqian.mybatis_plus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatis_plus.entity.Employee;
import com.haoqian.mybatis_plus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * 测试分页插件
     */
    @GetMapping("/selectByPage")
    public Page<Employee> selectByPage() {
        return employeeService.selectByPage();
    }

    /**
     * 测试分析执行插件
     */
    @GetMapping("/deleteAll")
    public int deleteAll() {
        return employeeService.deleteAll();
    }

    /**
     * 测试乐观锁插件
     */
    @GetMapping("/updateById")
    public int updateById() {
        return employeeService.updateById();
    }
}
