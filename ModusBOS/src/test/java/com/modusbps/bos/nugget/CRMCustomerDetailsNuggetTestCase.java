package com.modusbps.bos.nugget;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CRMCustomerDetailsNuggetTestCase {
	private Nugget nugget;
	private static final String MOBILE_NUMBER = "415-909-2990";
	private static final String SUGAR_CRM_URL = "https://jprdbe8125.trial.sugarcrm.eu/#Accounts";
	
	private static final String CIVIC_CRM_URL = "http://demo.fatfreecrm.com/contacts#";
	private static final String FATFREE_LOGIN_URL = "http://demo.fatfreecrm.com/login";

	

	@Before
	public void setUp() throws Exception {
		nugget = new CRMCustomerDetailsNugget(MOBILE_NUMBER);
	}
	
	@Ignore
	public void testProcessString() throws Exception{
		nugget.process(FATFREE_LOGIN_URL);
		
	}

	@After
	public void tearDown() throws Exception {
		nugget = null;
	}



}
