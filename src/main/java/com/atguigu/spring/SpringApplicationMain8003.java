package com.atguigu.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.spring.dao")
/**
 * @Mapper 一定要有，否则 Mybatis 找不到 mapper。
 * @Repository 可有可无，可以消去依赖注入的报错信息。
 * @MapperScan 可以替代 @Mapper。
 */
public class SpringApplicationMain8003 {

    public static void main(String[] args) {
       SpringApplication.run(SpringApplicationMain8003.class,args);
    }
}
