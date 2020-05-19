package com.atguigu.spring.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.spring.SpringApplicationMain8003;
import com.atguigu.spring.controller.PaymentController;
import com.atguigu.spring.entity.Payment;
import com.atguigu.spring.enums.ActivationModeEnum;
import com.atguigu.spring.enums.TestEnum;
import com.atguigu.spring.enums.ViewEnum;
import com.atguigu.spring.service.EnumService;
import com.atguigu.spring.service.PaymentService;

import com.atguigu.spring.utils.StringUtil;
import com.atguigu.spring.vo.CommonResult;
import org.junit.Test;
import org.junit.runner.RunWith;



import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApplicationMain8003.class)
public class TransactionTest {

    @Resource
    private PaymentService paymentService;

    @Resource
    private PaymentController paymentController;

    @Resource
    private EnumService enumService;


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

    @Test
    public void test03(){
        String str="abc-def";
        Map<String,Object> map=new HashMap<>();

        map.put("str",str);

        str= StringUtil.substringAfterLast(str,"-");

        System.out.println(str);
        String jsonString = JSON.toJSONString(map);


        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Map<String,Object> map1 =jsonObject;//    //json对象转Map

        System.out.println(map1.get("str"));




    }

    @Test
    public void test04(){

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        listA.add(5);

        listB.add(2);
        listB.add(3);
        listB.add(6);

        List<Integer> listC=new ArrayList<>();
        listC.addAll(listA);

        Integer i=2;


//        listA.retainAll(listB);
//        System.out.println(listA);
//
//
//
//        String str = "a,b,c";
//        List<String> result = Arrays.asList(str.split(","));
//        System.out.println(result);
//
//        String res = StringUtils.collectionToDelimitedString(result, ",");
//        System.out.println(res);
        //1,2,3,4,5         1，4，5
        //2,3,6
        //1.取差集 1，4，5  升级
        //listA.removeAll(listB);


        //2.取交集  2，3  停止，删除任务
        listB.retainAll(listA);
        //3.取和（在批量升级里,加上2,3）
        if (i==1){

            System.out.println(listA);
            System.out.println(listB);
        }else {
            //停止删除2，3
            //System.out.println(listB);
            //listA=listC;
            System.out.println(listA);
        }



        //

        //2.取差集
    }
    @Test
    public void test05(){

        System.out.println(ViewEnum.MERTER_FACTORY.getViewType());
    }

    @Test
    public void test06(){
        Integer viewType=1;
        TestEnum testEnum = TestEnum.getEnum(viewType);
        enumService.testEnum(testEnum);
    }

    @Test
    public void test07(){
        System.out.println(ActivationModeEnum.getActivationMode("1").getActiveModelName());


    }

    @Test
    public void test08() throws UnknownHostException {

        String addr = InetAddress.getLocalHost().getHostAddress();


        //String hostname = addr.getHostName();
        System.out.println(addr);


    }
}
