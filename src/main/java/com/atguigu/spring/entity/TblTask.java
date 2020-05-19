package com.atguigu.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date recvTime;

    /**
     * 调用次数
     */
    private Integer count;



}