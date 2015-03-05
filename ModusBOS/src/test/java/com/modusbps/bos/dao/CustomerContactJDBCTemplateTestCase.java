package com.modusbps.bos.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modusbps.bos.entity.CustomerContact;

public class CustomerContactJDBCTemplateTestCase {
	private ApplicationContext context;
	private CustomerContactJDBCTemplate customerContactJDBCTemplate;

	@Before
	public void setUp() throws Exception {
		context =  new ClassPathXmlApplicationContext("Spring-Module.xml");
		customerContactJDBCTemplate = (CustomerContactJDBCTemplate)context.getBean("customerContactJDBCTemplate");
		
	}
	
	@Test
	public void testCreateCustomerContact() {
		CustomerContact customerContact = new CustomerContact();
		customerContact.setCustomerId(1);
		customerContact.setCustomerFirstName("Laurence");
		customerContact.setCustomerLastName("Fish");
		customerContact.setEmailAddress("lfish@gmail.com");
		customerContact.setMobilePhoneNumber("083111111");
		customerContact.setTitle("Developer");
		
		customerContactJDBCTemplate.createCustomerContact(customerContact);
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		customerContactJDBCTemplate = null;
	}
}
