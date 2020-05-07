package com.atguigu.spring.service.impl;


import com.atguigu.spring.dao.PaymentDao;
import com.atguigu.spring.entity.Payment;
import com.atguigu.spring.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    //1.只用@Transactional和try...catch结合并没办法真正执行事务，因为这时候只回滚
    //RuntimeException异常，所以这个时候必须加上rollbackFor=Exception.class
    // 才能捕捉所有错误,如果有finally时，在finally只需要关闭相关资源就行，不要
    // 在finally中返回结果

    /**
     * 测试transaction和try....catch一块使用
     *
     * @param payment
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    //@Transactional
    public int create(Payment payment) throws Exception {
        int res = 0;

        try {

            res = paymentDao.create(payment);

            int i = 10 / 0;

            return res;

        } catch (Exception e) {
            e.printStackTrace();

            throw new Exception("测试一下插入问题");



        }finally {
            int i=1+1;
            System.out.println(i);
        }

    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    /**
     * 该方法是测试默认情况下方法抛出的异常
     */
    @Override
    public void test() {


        try {

            int i=10/0;

        }catch (RuntimeException e){

            e.printStackTrace();
        }


    }


}
