package com.modusbps.bos.crm.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modusbps.bos.dao.CustomerContactJDBCTemplate;
import com.modusbps.bos.entity.CRMCustomer;

public class CRMCustomerJDBCTemplateTestCase {
	private ApplicationContext context;
	private CRMCustomerJDBCTemplate crmCustomerJDBCTemplate;
	
	private static final String MSISDN = "072 999 7338";


	@Before
	public void setUp() throws Exception {
		context =  new ClassPathXmlApplicationContext("Spring-Module.xml");
		crmCustomerJDBCTemplate = (CRMCustomerJDBCTemplate)context.getBean("crmCustomerJDBCTemplate");
	}
	
	@Test
	public void testGetCustomerByMSISDN() {
		
		CRMCustomer crmCustomer = crmCustomerJDBCTemplate.getCustomerByMSISDN(MSISDN);
		
		System.out.println(crmCustomer.getAccountId());
		System.out.println(crmCustomer.getAccountName());
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		crmCustomerJDBCTemplate = null;
	}

}
