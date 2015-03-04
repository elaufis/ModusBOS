package com.modusbps.bos.entity;

import java.util.List;

public class Customer {
	private String customerName;
	private List<Address> addressList;
	private IndustryType industryType;
	private String officePhoneNumber;
	private String assignedSalesRep;
	private String mobilePhoneNumber;
	
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public IndustryType getIndustryType() {
		return industryType;
	}
	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}
	public String getOfficePhoneNumber() {
		return officePhoneNumber;
	}
	public void setOfficePhoneNumber(String officePhoneNumber) {
		this.officePhoneNumber = officePhoneNumber;
	}
	public String getAssignedSalesRep() {
		return assignedSalesRep;
	}
	public void setAssignedSalesRep(String assignedSalesRep) {
		this.assignedSalesRep = assignedSalesRep;
	}

}
