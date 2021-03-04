package com.haoqian.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.haoqian.mybatis_plus.myEnum.AgeEnum;
import com.haoqian.mybatis_plus.myEnum.GradeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_student")
public class Student {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private AgeEnum age;
    private GradeEnum grade;
    // 自动填充字段
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String status;
    // 逻辑删除
    @TableLogic
    private Integer deleted;
}
