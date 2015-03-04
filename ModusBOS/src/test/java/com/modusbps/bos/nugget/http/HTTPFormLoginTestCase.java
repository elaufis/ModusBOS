package com.modusbps.bos.nugget.http;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HTTPFormLoginTestCase {
	private HTTPFormLogin httpFormLogin;
	
	private static final String LOGIN_URL = "http://demo.fatfreecrm.com/login";
	private static final String SEARCH_URL = "http://demo.fatfreecrm.com/contacts";
	private static final String USERNAME = "aaron";
	private static final String PASSWORD = "aaron";

	@Before
	public void setUp() throws Exception {
		httpFormLogin = new HTTPFormLogin(LOGIN_URL, SEARCH_URL);
	}
	
	@Ignore
	public void testLoginAndNavigate() throws Exception{
		String result = httpFormLogin.loginAndNavigate(USERNAME, PASSWORD);
		System.out.println(result);
	}

	@After
	public void tearDown() throws Exception {
		httpFormLogin = null;
	}



}
