package com.atguigu.spring.enums;

public enum ActivationModeEnum {

	TIME("1","Activate Immediately"),IMMEDIATELY("2","Activate Immediately");

	private String activationMode;

	private String activeModelName;

	ActivationModeEnum(String activationMode, String activeModelName) {
		this.activationMode = activationMode;
		this.activeModelName=activeModelName;
	}
	//根据字符查询值
	public static ActivationModeEnum getActivationMode(String activationMode){
		if (activationMode==null){

			return null;
		}

		for (ActivationModeEnum activationModeEnum : ActivationModeEnum.values()){

			if (activationModeEnum.getActivationMode().equals(activationMode)){

				return activationModeEnum;
			}
		}
		return null;
	}

	public String getActivationMode() {
		return activationMode;
	}

	public String getActiveModelName(){
		return activeModelName;
	}
}
