package com.atguigu.spring.enums;


import org.springframework.stereotype.Component;


public enum  ViewEnum {

    TMNL_TYPE("tmnlTypeMap"),METER_TYPE("meterTypeMap"),MERTER_FACTORY("meterFactoryTypeMap"),
    TMNL_FACTORY("tmnlFactoryTypeMap"),METER_COMM_MODEL("meterCommModelMap"),
    METER_VOLT("meterVoltMap"),METER_VM_CORRENT("meterVmCorrentMap"),
    UPGRADE_PART_TYPE("upgradePartTypeMap"),
    UPGRADE_FILE_TYPE("upgradeFileTypeMap"),CURRENT("currentMap");



    private String viewType;


    ViewEnum(String viewType) {
        this.viewType=viewType;
    }

    //根据字符查询值
    public static ViewEnum getViewTypeCode(String viewType){
        if (viewType==null){

            return null;
        }

        for (ViewEnum viewEnum : ViewEnum.values()){

            if (viewEnum.viewType.equals(viewType)){

                return viewEnum;
            }
        }
        return null;
    }

    public String getViewType() {
        return viewType;
    }
}

