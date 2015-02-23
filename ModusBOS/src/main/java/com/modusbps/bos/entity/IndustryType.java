package com.modusbps.bos.entity;

public enum IndustryType {
	BANKING		(0, "Banking"),
	HEALTHCARE 	(1, "HealthCare"),
	OTHER		(2, "Other");
	
	
	private String description;
	private int code = -1;
	
	public String getDescription(){
	   return description;
	}
	
	public int getCode() {
	   return this.code;
	}
	
	private IndustryType(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static IndustryType valueOf(int code){
		for (IndustryType general: values()){
			if  (general.getCode() == code){
				return general;
			}
		}
		return  OTHER;
	}
}
