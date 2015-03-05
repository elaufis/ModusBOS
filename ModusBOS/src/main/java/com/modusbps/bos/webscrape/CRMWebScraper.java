package com.modusbps.bos.webscrape;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.modusbps.bos.entity.CustomerContact;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class CRMWebScraper {
	private WebDriver webDriver;
	private String baseUrl;

	public CRMWebScraper(){
		this.webDriver = new ChromeDriver();
		baseUrl = "http://130.211.56.37:3000/";
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	private void loginToCRM(){
		webDriver.get(baseUrl + "/login");
		webDriver.findElement(By.id("authentication_username")).clear();
		webDriver.findElement(By.id("authentication_username")).sendKeys("admin");
		webDriver.findElement(By.id("authentication_password")).clear();
		webDriver.findElement(By.id("authentication_password")).sendKeys("password");
		webDriver.findElement(By.id("authentication_remember_me")).click();
		webDriver.findElement(By.name("commit")).click();
	}

	public CustomerContact getCustomerContactData(String msisdn){
		CustomerContact customerContact = new CustomerContact();
		loginToCRM();

		webDriver.get(baseUrl + "/profile");
		webDriver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[2]")).click();
		webDriver.findElement(By.id("query")).clear();
		webDriver.findElement(By.id("query")).sendKeys(msisdn);
		webDriver.findElement(By.cssSelector("div.indentslim > a")).click();
		webDriver.findElement(By.id("edit_contact_arrow")).click();
		
		String firstName = webDriver.findElement(By.id("contact_first_name")).getText();
		String lastName = webDriver.findElement(By.id("contact_last_name")).getText();
		String email = webDriver.findElement(By.id("contact_email")).getText();
		String phone = webDriver.findElement(By.id("contact_phone")).getText();
		
		customerContact.setCustomerFirstName(firstName);
		customerContact.setCustomerLastName(lastName);
		customerContact.setEmailAddress(email);
		customerContact.setMobilePhoneNumber(phone);
		customerContact.setCustomerId(1);

		return customerContact;
	}
}
