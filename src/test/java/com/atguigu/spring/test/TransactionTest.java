package com.atguigu.spring.test;

import com.atguigu.spring.controller.PaymentController;
import com.atguigu.spring.entity.Payment;
import com.atguigu.spring.service.PaymentService;

import com.atguigu.spring.vo.CommonResult;
import org.junit.Test;
import org.junit.runner.RunWith;



import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)//声明springboot环境
public class TransactionTest {

    @Resource
    private PaymentService paymentService;

    @Resource
    private PaymentController paymentController;


    @Test
    public void test01(){

        Payment payment=new Payment();

        payment.setSerial("hxy");


        //paymentService.create(payment);



    }

    @Test
    public void test02(){



        //Payment payment=paymentService.getPaymentById(Long.valueOf(1));
        // System.out.println(payment);


        CommonResult<Payment> commonResult = paymentController.getPaymentById(Long.valueOf(1));


        System.out.println(commonResult);


    }
}
