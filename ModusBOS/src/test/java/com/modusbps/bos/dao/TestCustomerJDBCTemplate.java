package com.modusbps.bos.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modusbps.bos.entity.Customer;
import com.modusbps.bos.entity.IndustryType;

public class TestCustomerJDBCTemplate {
	private ApplicationContext context;
	private CustomerJDBCTemplate customerJDBCTemplate;
	private Customer customer;
	
	@Ignore
	public void setUp() throws Exception {
		 context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		 customerJDBCTemplate = (CustomerJDBCTemplate)context.getBean("customerJDBCTemplate");
	}

//	@Test
//	public void testSetDataSource() throws Exception {
//		customerJDBCTemplate = (CustomerJDBCTemplate)context.getBean("customerJDBCTemplate");
//	}
	
	@Ignore
	public void testCreateCustomer() throws Exception {
		customer = new Customer();
		customer.setCustomerId(5);
		customer.setCustomerName("CLM");
		customer.setAssignedSalesRep("LF");
		customer.setIndustryType(IndustryType.BANKING);
		
		customerJDBCTemplate.createCustomer(customer);
	}

//	@Test
//	public void testGetCustomersByRep() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetCustomerByMSISDN() {
//		fail("Not yet implemented");
//	}

	@After
	public void tearDown() throws Exception {
		customer = null;
		context = null;
		customerJDBCTemplate = null;
	}


}
