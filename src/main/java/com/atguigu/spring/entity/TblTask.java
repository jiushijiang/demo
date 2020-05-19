package com.atguigu.spring.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * tbl_task
 * @author 
 */
@Data
public class TblTask implements Serializable {
    /**
     * id编号，自增
     */
    private Integer id;

    /**
     * 定时时间，用于转换
     */
    private Date recvTime;

    /**
     * 调用次数
     */
    private Integer count;



}