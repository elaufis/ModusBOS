package com.modusbps.bos.dao;

import java.util.List;

import javax.sql.DataSource;

import com.modusbps.bos.entity.CustomerContact;

public interface CustomerContactDAO {
	public void setDataSource(DataSource dataSource);
	
	public CustomerContact getCustomerByMSISDN(String msisdn);
	
	public void createCustomerContact(CustomerContact customer);
	
	public List<CustomerContact> getCustomerContactsByCustomerId(int custId);

}
