package com.haoqian.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haoqian.mybatis_plus.entity.Employee;
import com.haoqian.mybatis_plus.mapper.EmployeeMapper;
import com.haoqian.mybatis_plus.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author haoqian
 * @since 2020-12-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    public Employee selectById(Long id) {
        //方法一: BaseMapper提供的方法, baseMapper在ServiceImpl中注入了，可以直接使用
        // Employee employee = baseMapper.selectById(id);

        //方法二: IService提供的方法, this表示当前类EmployeeServiceImpl
        Employee employee = this.getById(id);
        return employee;
    }

}
