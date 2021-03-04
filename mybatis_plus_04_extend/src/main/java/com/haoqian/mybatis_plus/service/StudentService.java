package com.haoqian.mybatis_plus.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatis_plus.entity.Employee;
import com.haoqian.mybatis_plus.entity.Student;
import com.haoqian.mybatis_plus.mapper.EmployeeMapper;
import com.haoqian.mybatis_plus.mapper.StudentMapper;
import com.haoqian.mybatis_plus.myEnum.AgeEnum;
import com.haoqian.mybatis_plus.myEnum.GradeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Mapper CRUD 接口的方法测试
 */
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    /**
     * 测试插入时自动填充
     */
    public int insertAutoFill() {
        Student student = new Student();
        student.setName("小六");
        return studentMapper.insert(student);
    }


    /**
     * 测试更新时自动填充
     */
    public int updateAutoFill() {
        Student student = studentMapper.selectById(2);
        student.setName("小六-修改");
        student.setStatus(null);
        return studentMapper.updateById(student);
    }


    /**
     * 测试将枚举类型的值插入数据库
     */
    public void saveEnum() {
        Student student = new Student();
        student.setName("小王");
        student.setAge(AgeEnum.THREE);
        student.setGrade(GradeEnum.HIGH);

        studentMapper.insert(student);  // 自动生成主键会回写
        Student result = studentMapper.selectById(student.getId());
        System.out.println("查询结果：" + result);
    }

}
