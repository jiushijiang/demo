package com.atguigu.spring.dao;

import com.atguigu.spring.entity.TblTask;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblTaskDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblTask record);

    int insertSelective(TblTask record);

    TblTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblTask record);

    int updateByPrimaryKey(TblTask record);

    TblTask getTaskTimeById();
}