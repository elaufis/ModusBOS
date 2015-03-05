package com.modusbps.bos.crm.dao;

import java.util.List;

import javax.sql.DataSource;

import com.modusbps.bos.entity.CRMCustomer;

public interface CRMCustomerDetailDAO {
	public void setDataSource(DataSource dataSource);
	
	public CRMCustomer getCustomerByMSISDN(String msisdn);
	
	public List<CRMCustomer> getCustomerContactsByCustomerId(int custId);
}
