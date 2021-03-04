package com.haoqian.mybatis_plus.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatis_plus.entity.Employee;
import com.haoqian.mybatis_plus.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Mapper CRUD 接口的方法测试
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    /**
     * 带条件的分页查询
     * <p>
     * SELECT id,last_name,email,gender,age
     * FROM tbl_employee
     * WHERE (age BETWEEN ? AND ? AND gender = ? AND last_name LIKE ?) LIMIT ? OFFSET ?
     */
    public Page<Employee> selectByPage() {
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
     * 测试自定义SQL注入器 添加的方法
     */
    public int deleteAll() {
        int affectedNum = employeeMapper.deleteAll();
        return affectedNum;
    }


    /**
     * 测试乐观锁
     * 更新前有别人进行更新的情况下，会执行，但是更新数量为0
     */
    public int updateById() {
        Employee employee = employeeMapper.selectById(1);
        employee.setAge(99);

        // 延迟10秒，模拟用户修改过程
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int affectedNum = employeeMapper.updateById(employee);
        System.out.println("被更新的数量：" + affectedNum);
        return affectedNum;
    }

    /**
     * 测试逻辑删除
     */
    public void logicDelete() {
        System.out.println("逻辑删除对查询语句的影响：");
        Employee employee = employeeMapper.selectById(2);
        System.out.println("逻辑删除对更新语句的影响：");
        employee.setAge(99);
        employeeMapper.updateById(employee);
        System.out.println("逻辑删除对删除语句的影响：");
        employeeMapper.deleteById(employee.getId());
    }
}
