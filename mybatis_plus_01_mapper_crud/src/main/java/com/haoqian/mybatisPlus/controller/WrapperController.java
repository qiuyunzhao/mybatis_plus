package com.haoqian.mybatisPlus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatisPlus.entity.Employee;
import com.haoqian.mybatisPlus.service.WrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 条件构造器 测试
 */
@RestController
public class WrapperController {

    @Autowired
    WrapperService wrapperService;

    @GetMapping("/wrapper/select1")
    public Page<Employee> select1() {
        return wrapperService.select1();
    }

    @GetMapping("/wrapper/select2")
    public List<Employee> select2() {
        return wrapperService.select2();
    }

    @GetMapping("/wrapper/select3")
    public List<Employee> select3() {
        return wrapperService.select3();
    }

    @GetMapping("/wrapper/select4")
    public List<Employee> select4() {
        return wrapperService.select4();
    }

    @PutMapping("/wrapper/update1")
    public Integer update1(@RequestBody Employee employee) {
        return wrapperService.update1(employee);
    }

    @DeleteMapping("/wrapper/delete1")
    public Integer delete1() {
        return wrapperService.delete1();
    }
}
