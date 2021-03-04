package com.haoqian.mybatisPlus.service;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatisPlus.entity.Employee;
import com.haoqian.mybatisPlus.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 条件构造器 测试
 */
@Service
public class WrapperService {

    @Autowired
    EmployeeMapper employeeMapper;

    // ================================================== 条件查询 ======================================================

    /**
     * 带条件的分页查询
     * <p>
     * SELECT id,last_name,email,gender,age
     * FROM tbl_employee
     * WHERE (age BETWEEN ? AND ? AND gender = ? AND last_name LIKE ?) LIMIT ? OFFSET ?
     */
    public Page<Employee> select1() {
        Page<Employee> page = new Page<>(2, 2);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.between("age", 18, 50)
                .eq("gender", 1)
                .likeLeft("email", "com");

        // employeePage与page是同一个对象
        Page<Employee> employeePage = employeeMapper.selectPage(page, wrapper);
        System.out.println("是否有上一页" + page.hasNext());
        System.out.println("是否有下一页" + page.hasNext());
        return employeePage;
    }

    /**
     * or连接
     * <p>
     * SELECT id,last_name,email,gender,age
     * FROM tbl_employee
     * WHERE (gender = ? OR email LIKE ?)
     */
    public List<Employee> select2() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", 1)
                .or()
                .likeLeft("email", "@qq.com");
        List<Employee> employees = employeeMapper.selectList(wrapper);
        return employees;
    }

    /**
     * or 嵌套
     * <p>
     * SELECT id,last_name,email,gender,age
     * FROM tbl_employee
     * WHERE (gender = ? AND email LIKE ? OR (age > ? AND age < ?))
     */
    public List<Employee> select3() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", 1).likeLeft("email", "@qq.com")
                .or(i -> i.gt("age", 18).lt("age", 50));

        List<Employee> employees = employeeMapper.selectList(wrapper);
        return employees;
    }

    /**
     * 排序
     * <p>
     * SELECT id,last_name,email,gender,age
     * FROM tbl_employee
     * WHERE (age > ?) ORDER BY age ASC,gender DESC
     */
    public List<Employee> select4() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 0)
                .orderByAsc("age")
                .orderByDesc("gender");

        List<Employee> employees = employeeMapper.selectList(wrapper);
        return employees;
    }
    // ================================================== 条件修改 ======================================================

    /**
     * 更新employee中字段不为空的值, like双边 %
     * <p>
     * UPDATE tbl_employee
     * SET last_name=?, email=?
     * WHERE (last_name = ? AND email LIKE ?)
     */
    public int update1(Employee employee) {
        System.out.println("--->条件employee:" + employee);
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                // 修改条件(第一个参数为true时，包含此条件)
                .eq(employee.getLastName() != null, "last_name", "demoData")
                .like(employee.getEmail() != null, "email", "demoData")
                .ge(employee.getAge() != null, "age", "18");
        return employeeMapper.update(employee, updateWrapper); // 返回受影响的记录数
    }

    // ================================================== 条件删除 ======================================================

    /**
     * 条件删除
     * <p>
     * DELETE FROM tbl_employee
     * WHERE (last_name IS NULL AND email IS NOT NULL OR age IN (?,?))
     */
    public int delete1() {

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .isNull("last_name")
                .isNotNull("email")
                .or()
                .in("age", Arrays.asList(18, 24));

        return employeeMapper.delete(queryWrapper); // 返回受影响的记录数
    }
}
