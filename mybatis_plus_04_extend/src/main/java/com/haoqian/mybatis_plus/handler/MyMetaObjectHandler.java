package com.haoqian.mybatis_plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * metaobject：元对象
 * 是 Mybatis 提供的一个用于更加方便，更加优雅的访问对象的属性，给对象的属性设置值的一个对象，
 * 还会用于包装对象，支持对 Object 、Map、Collection等对象进行包装，
 * 本质上 metaObject 获取对象的属性值或者是给对象的属性设置值，
 * 最终是要通过 Reflector 获取到属性的对应方法的 Invoker，最终 invoke。
 * <p>
 * MetaObjectHandler提供的默认方法的策略均为:如果属性有值则不覆盖,如果填充值为null则不填充
 */

@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入满足自动填充条件, start insert fill ....");
        this.strictInsertFill(metaObject, "status", String.class, "插入");

//        Object status = getFieldValByName("status", metaObject);
//        if (status == null) {
//            log.info("插入满足自动填充条件, start insert fill ....");
//            this.strictInsertFill(metaObject, "status", String.class, "插入");
//        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新满足自动填充条件, start insert fill ....");
        this.strictUpdateFill(metaObject, "status", String.class, "更新");

//        Object status = getFieldValByName("status", metaObject);
//        if (status == null) {
//            log.info("更新满足自动填充条件, start insert fill ....");
//            this.strictUpdateFill(metaObject, "status", String.class, "更新");
//        }
    }
}