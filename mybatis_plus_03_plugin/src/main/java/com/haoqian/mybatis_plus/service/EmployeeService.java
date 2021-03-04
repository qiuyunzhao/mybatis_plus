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
     * =================================================== 分页插件测试 ======================================================
     */

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
     * =================================================== 执行分析插件测试 ======================================================
     */

    /**
     * 全表删除或更新会报错
     */
    public int deleteAll() {
        int affectedNum = employeeMapper.delete(null);
        return affectedNum;
    }

    /**
     * =================================================== 乐观锁插件测试 ======================================================
     */

    /**
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

}
