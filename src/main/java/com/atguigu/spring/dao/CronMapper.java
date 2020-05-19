package com.atguigu.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
    public interface CronMapper {
        @Select("select cron from cron limit 1")
        public String getCron();
    }