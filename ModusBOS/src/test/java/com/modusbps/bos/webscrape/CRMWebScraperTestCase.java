package com.modusbps.bos.webscrape;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.modusbps.bos.entity.CustomerContact;

public class CRMWebScraperTestCase {
	private CRMWebScraper crmWebScraper;
	
	private static final String MSISDN = "072 999 7338";

	@Before
	public void setUp() throws Exception {
		crmWebScraper = new CRMWebScraper();
	}
	
	@Test
	public void testGetCustomerContactData() {
		CustomerContact customerContact = crmWebScraper.getCustomerContactData(MSISDN);
		
		System.out.println("First Name: " + customerContact.getCustomerFirstName());
		System.out.println("Last Name: " + customerContact.getCustomerLastName());
		System.out.println("Email: " + customerContact.getEmailAddress());
		System.out.println("Phone: " + customerContact.getMobilePhoneNumber());
	}

	@After
	public void tearDown() throws Exception {
		crmWebScraper = null;
	}
}
