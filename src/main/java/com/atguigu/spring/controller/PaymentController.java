package com.atguigu.spring.controller;

import com.atguigu.spring.entity.Payment;
import com.atguigu.spring.service.PaymentService;
import com.atguigu.spring.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;



    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) throws Exception {

        int result=paymentService.create(payment);

        log.info("*************"+result+"****************");

        if (result>0){
            return new CommonResult(200,"插入数据库成功,port:"+port,result);
        }

        return new CommonResult(400,"插入失败！",null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment=paymentService.getPaymentById(id);

        log.info("**************查询到的数据为"+payment+"*****************");

        if (payment != null){
            return new CommonResult(200,"查找成功,port:"+port,payment);
        }

        return new CommonResult(400,"查找失败！",null);
    }

    @GetMapping("/payment/testException")
    public CommonResult<Payment> testException(){

        paymentService.test();
        return new CommonResult(400,"执行runtimeException！",null);
    }





}