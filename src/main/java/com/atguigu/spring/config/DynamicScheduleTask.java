package com.atguigu.spring.config;

import com.atguigu.spring.dao.CronMapper;
import com.atguigu.spring.dao.TblTaskDao;

import com.atguigu.spring.entity.TblTask;
import com.atguigu.spring.utils.DateUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {



    @Autowired      //注入mapper
    @SuppressWarnings("all")
    CronMapper cronMapper;



    @Resource
    private TblTaskDao tblTaskDao;

    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    //String cron = cronMapper.getCron();

                    //TblTime tblTime = tblTimeDao.selectByPrimaryKey(1);
                    //Date time = tblTime.getTime();
                    //String timeStr=DateUtil.getCron(time);


                    TblTask tblTask = tblTaskDao.getTaskTimeById();

                    String timeStr="0 0 * * *  ?" ;//默认一小时调一次;
                    if (tblTask!=null){


                        Date recvTime = tblTask.getRecvTime();

                         timeStr = DateUtil.getCron(recvTime);

                    }


//
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(timeStr)) {


                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(timeStr).nextExecutionTime(triggerContext);

                }
        );
    }


}