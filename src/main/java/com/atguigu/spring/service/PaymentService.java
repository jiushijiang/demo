package com.atguigu.spring.service;


import com.atguigu.spring.entity.Payment;

public interface PaymentService {


    public int create(Payment payment) throws Exception;

    public Payment getPaymentById(Long id);


    public void test();
}
