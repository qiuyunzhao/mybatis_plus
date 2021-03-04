package com.haoqian.mybatisPlus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatisPlus.entity.Employee;
import com.haoqian.mybatisPlus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Mapper CRUD 接口的方法测试
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * =================================================== 增 ======================================================
     */
    @PostMapping("employee/insert")
    public int insert(@RequestBody Employee employee) {
        return employeeService.insert(employee);
    }

    /**
     * =================================================== 删 ======================================================
     */

    @DeleteMapping("employee/delete/{id}")
    public Integer delete(@PathVariable Integer id) {
        return employeeService.delete(id);
    }


    @DeleteMapping("employee/deleteById/{id}")
    public Integer deleteById(@PathVariable Integer id) {
        return employeeService.deleteById(id);
    }

    @DeleteMapping("employee/deleteByMap")
    public Integer deleteByMap(@RequestBody Map<String, Object> columnConditionMap) {
        return employeeService.deleteByMap(columnConditionMap);
    }

    @DeleteMapping("employee/deleteBatchIds")
    public Integer deleteBatchIds(@RequestBody List<Integer> ids) {
        return employeeService.deleteBatchIds(ids);
    }

    /**
     * =================================================== 改 ======================================================
     */
    @PutMapping("employee/updateById")
    public int updateById(@RequestBody Employee employee) {
        return employeeService.updateById(employee);
    }

    @PutMapping("employee/update")
    public int update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    /**
     * =================================================== 查 ======================================================
     */

    @GetMapping("employee/selectById/{id}")
    public Employee selectById(@PathVariable Integer id) {
        return employeeService.selectById(id);
    }

    @GetMapping("employee/selectList")
    public List<Employee> selectList(Employee employee) {
        return employeeService.selectList(employee);
    }

    @GetMapping("employee/selectMaps")
    public List<Map<String, Object>> selectMaps(Employee employee) {
        return employeeService.selectMaps(employee);
    }

    @GetMapping("employee/selectObjs")
    public List<Object> selectObjs(Employee employee) {
        return employeeService.selectObjs(employee);
    }

    @PostMapping("employee/selectOne")
    public Employee selectOne(@RequestBody Employee employee) {
        return employeeService.selectOne(employee);
    }

    @PostMapping("employee/selectBatchIds")
    public List<Employee> selectBatchIds(@RequestBody List<Integer> ids) {
        return employeeService.selectBatchIds(ids);
    }

    @PostMapping("employee/selectByMap")
    public List<Employee> selectByMap(@RequestBody Map<String, Object> columnConditionMap) {
        return employeeService.selectByMap(columnConditionMap);
    }

    @PostMapping("employee/selectPage")
    public Page<Employee> selectPage(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return employeeService.selectPage(currentPage, pageSize);
    }

    @PostMapping("employee/selectMapsPage")
    public Page<Map<String, Object>> selectMapsPage(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return employeeService.selectMapsPage(currentPage, pageSize);
    }

    @GetMapping("employee/selectCount")
    public Integer selectCount(Employee employee) {
        return employeeService.selectCount(employee);
    }

}
