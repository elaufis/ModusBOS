package com.modusbps.bos.dao;

import static org.junit.Assert.fail;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modusbps.bos.entity.IncomingCallPoll;

public class IncomingCallPollJDBCTemplateTestCase {
	private ApplicationContext context;
	private IncomingCallPollJDBCTemplate incomingCallPollJDBCTemplate;
	private IncomingCallPoll incomingCallPoll;
	
	private static final String ID = "43045603456030192";
	private static final String DATA = "0829009358 0829009358";
	private static final String DESCRIPTION = "NA";
	private static final String TYPE = "NA";

	@Before
	public void setUp() throws Exception {
		 context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		 incomingCallPollJDBCTemplate = (IncomingCallPollJDBCTemplate)context.getBean("incomingCallPollJDBCTemplate");
	}
	
	@Test
	public void testCreateIncomingCallPoll() {
		incomingCallPoll = new IncomingCallPoll();
		incomingCallPoll.setId(ID);
		incomingCallPoll.setData(DATA);
		incomingCallPoll.setDescription(DESCRIPTION);
		incomingCallPoll.setType(TYPE);
		incomingCallPoll.setFlag(0);
		
		incomingCallPollJDBCTemplate.createIncomingCallPoll(incomingCallPoll);
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		incomingCallPollJDBCTemplate = null;
		
	}
}
