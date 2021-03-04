package com.haoqian.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haoqian.mybatisPlus.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * 继承com.baomidou.mybatisplus.core.mapper.BaseMapper接口
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

}