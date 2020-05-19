package com.atguigu.spring.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_time
 * @author 
 */
public class TblTime implements Serializable {
    private Integer id;

    private Date time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}