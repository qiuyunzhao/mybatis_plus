package com.haoqian.mybatis_plus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatis_plus.entity.Employee;
import com.haoqian.mybatis_plus.service.EmployeeService;
import com.haoqian.mybatis_plus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/insertAutoFill")
    public int insertAutoFill() {
        return studentService.insertAutoFill();
    }

    @GetMapping("/updateAutoFill")
    public int updateAutoFill() {
        return studentService.updateAutoFill();
    }

    @GetMapping("/saveEnum")
    public void saveEnum() {
        studentService.saveEnum();
    }
}
