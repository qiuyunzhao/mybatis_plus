package com.haoqian.mybatis_plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.haoqian.mybatisPlus.mapper")
public class MybatisPlus02ServiceCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus02ServiceCrudApplication.class, args);
    }

}
