package com.modusbps.bos.webscrape;

import com.modusbps.bos.entity.CustomerContact;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class CRMWebScraper {
	@SuppressWarnings("deprecation")
	private Selenium crmSelenium;
	
	
	@SuppressWarnings("deprecation")
	public CRMWebScraper(){
		crmSelenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://130.211.56.37:3000/contacts");
		crmSelenium.start();
	}
	
	public CustomerContact getCustomerContactData(){
		return null;
	}
	
	
	

}
