package com.modusbps.bos.entity;

public enum AddressType {
	SHIPPING 		(0, "Primary"),
	BILLING			(1, "Billing"),
	PRIMARY			(2, "Primary"),
	ALTERNATE		(3, "Alternate"),
	OTHER			(4, "Other");
	
	private String description;
	private int code = -1;
	
	public String getDescription(){
	   return description;
	}
	
	public int getCode() {
	   return this.code;
	}
	
	private AddressType(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static AddressType valueOf(int code){
		for (AddressType general: values()){
			if  (general.getCode() == code){
				return general;
			}
		}
		return  OTHER;
	}

}
