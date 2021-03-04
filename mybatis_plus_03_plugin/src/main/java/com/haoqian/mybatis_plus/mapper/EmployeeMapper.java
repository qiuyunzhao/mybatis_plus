package com.haoqian.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haoqian.mybatis_plus.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * 继承com.baomidou.mybatisplus.core.mapper.BaseMapper接口
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

}