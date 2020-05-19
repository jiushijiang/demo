package com.atguigu.spring.controller;

import com.atguigu.spring.entity.TblTask;
import com.atguigu.spring.service.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TablTaskController {


    @Autowired
    private EnumService enumService;


    @PostMapping("/insert")
    public int insert(@RequestBody TblTask task) {

        enumService.insert(task);

        return 0;
    }
}
