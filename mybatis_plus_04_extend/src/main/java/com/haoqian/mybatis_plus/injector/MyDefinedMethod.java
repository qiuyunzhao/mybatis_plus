package com.haoqian.mybatis_plus.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 作用：将方法和sql做映射
 * <p>
 * 继承AbstractMethod
 * 重写injectMappedStatement方法
 * 将预编译sql和方法名进行绑定，并将自定义预编译sql与其他预编译sql包装后返回MappedStatement对象
 */
public class MyDefinedMethod extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        // EmployeeMapper接口中自定义映射的方法名
        String methodName = "deleteAll";
        // 构造该方法映射的sql预编译语句
        String sql = "delete from " + tableInfo.getTableName();
        // 进行预编译得到sqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        // 将上述预编译sql和mybatis的其它delete相关的编译sql存在一起
        return addDeleteMappedStatement(mapperClass, methodName, sqlSource);
    }
}