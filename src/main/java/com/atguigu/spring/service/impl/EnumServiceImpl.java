package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.TblTaskDao;
import com.atguigu.spring.entity.TblTask;
import com.atguigu.spring.enums.TestEnum;
import com.atguigu.spring.enums.ViewEnum;
import com.atguigu.spring.service.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EnumServiceImpl implements EnumService {


    @Resource
    private TblTaskDao  tblTaskDao;


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

    
    @Override
    public int insert(TblTask record) {

        int id=tblTaskDao.getMaxId();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        record.setId(id);
        tblTaskDao.insert(record);

        System.out.println(id);
        return 0;
    }
}
