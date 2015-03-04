package com.modusbps.bos.utils;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CallNotifierUtilTestCase {
	private CallNotifierUtil callNotifierUtil;
	
	private static final String MSG = "id=43045603456030192\ndata=0829009358 0829009358\ndescription=NA\ntype=NA";
	
	@Before
	public void setUp() throws Exception {
		callNotifierUtil = new CallNotifierUtil();
	}
	
	@Test
	public void testParseIncomingCallMessage() {
		Map<String, String> parsedMessage = callNotifierUtil.parseIncomingCallMessage(MSG);
		
		System.out.println(parsedMessage.get("id"));
	}

	@After
	public void tearDown() throws Exception {
		callNotifierUtil = null;
	}


}
