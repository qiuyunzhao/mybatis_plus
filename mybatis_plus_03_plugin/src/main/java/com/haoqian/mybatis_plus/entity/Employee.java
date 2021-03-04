package com.haoqian.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * @TableName 数据库表名映射注解
 * value： 指定数据库表名称(如果表名称与实体类名首字母小写一致可省略)
 */
@TableName("tbl_employee")
public class Employee {
    /**
     * @TableId 主键字段映射注解
     * value：指定数据库主键字段名为id(与属性名相同可省略)
     * type ：主键生成策略
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * @TableField 非主键字段
     */
    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;
    /**
     * exist属性: 是否映射数据库字段
     */
    @TableField(exist = false)
    private BigDecimal salary;

    /**
     * @Version 乐观锁
     */
    @Version
    private Integer version;
}
