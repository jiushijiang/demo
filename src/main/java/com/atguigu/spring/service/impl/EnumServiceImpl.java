package com.atguigu.spring.service.impl;

import com.atguigu.spring.enums.TestEnum;
import com.atguigu.spring.enums.ViewEnum;
import com.atguigu.spring.service.EnumService;
import org.springframework.stereotype.Service;

@Service
public class EnumServiceImpl implements EnumService {


    @Override
    public void testEnum(TestEnum testEnum) {

        switch (testEnum) {

            case SATURDAY:
                System.out.println("星期"+TestEnum.SATURDAY.getValue());
                break;
            case MONDAY:
                System.out.println("星期"+TestEnum.MONDAY.getValue());
                break;
            default:
                System.out.println("输出错误");
        }




    }
}
