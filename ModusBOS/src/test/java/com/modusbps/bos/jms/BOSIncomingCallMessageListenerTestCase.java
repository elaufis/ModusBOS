package com.modusbps.bos.jms;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BOSIncomingCallMessageListenerTestCase {
	private BOSIncomingCallMessageListener listener;

	@Before
	public void setUp() throws Exception {
		listener = new BOSIncomingCallMessageListener();
	}
	
	@Ignore
	public void testOnMessage() {
		fail("Not yet implemented");
	}

	@After
	public void tearDown() throws Exception {
		listener = null;
	}
}
