package com.modusbps.bos.dao;

import java.util.List;

import javax.sql.DataSource;

import com.modusbps.bos.entity.Customer;

public interface CustomerDAO {
	
	public void setDataSource(DataSource dataSource);
	
	public Customer getCustomerByMSISDN(String msisdn);
	
	public void createCustomer(Customer customer);
	
	public List<Customer> getCustomersByRep(String repNo);

}
