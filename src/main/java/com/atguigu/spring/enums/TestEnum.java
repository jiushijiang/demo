package com.atguigu.spring.enums;

public enum  TestEnum {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);



    private Integer value;


    TestEnum(Integer value) {
        this.value=value;
    }

    //根据字符查询值
    public static TestEnum getEnum(Integer value){
        if (value==null){

            return null;
        }

        for (TestEnum testEnum : TestEnum.values()){

            if (testEnum.value.equals(value)){

                return testEnum;
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }
}
