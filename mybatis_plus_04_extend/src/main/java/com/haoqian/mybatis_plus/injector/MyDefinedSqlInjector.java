package com.haoqian.mybatis_plus.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义SQL注入器
 * 将自定义的sql与方法绑定的实例，交给自定义SQL注入器管理
 */
public class MyDefinedSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        // 将原来的保持
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        // 将自定义的方法传入
        methodList.add(new MyDefinedMethod());
        return methodList;
    }

}