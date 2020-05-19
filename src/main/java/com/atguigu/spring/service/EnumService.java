package com.atguigu.spring.service;

import com.atguigu.spring.entity.TblTask;
import com.atguigu.spring.enums.TestEnum;
import com.atguigu.spring.enums.ViewEnum;

public interface EnumService {

    public void testEnum(TestEnum testEnum);


    public int insert(TblTask record);
}
