package com.modusbps.bos.jms;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modusbps.bos.dao.IncomingCallPollJDBCTemplate;
import com.modusbps.bos.entity.IncomingCallPoll;
import com.modusbps.bos.utils.CallNotifierUtil;

public class BOSIncomingCallMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage)
		{
			try
			{
				String msgText = ((TextMessage) message).getText();
				CallNotifierUtil util = new CallNotifierUtil(msgText);
				
				String msisdn = util.getMSISDNFromMessage();
				
				Map<String, String> msgMap = util.parseIncomingCallMessage();
				
				ApplicationContext context =  new ClassPathXmlApplicationContext("Spring-Module.xml");
				IncomingCallPollJDBCTemplate incomingCallPollJDBCTemplate = (IncomingCallPollJDBCTemplate)context.getBean("incomingCallPollJDBCTemplate");
				
				IncomingCallPoll incomingCallPoll = new IncomingCallPoll();
				incomingCallPoll.setId(msgMap.get("id"));
				incomingCallPoll.setData(msgMap.get("data"));
				incomingCallPoll.setDescription(msgMap.get("description"));
				incomingCallPoll.setType(msgMap.get("type"));
				incomingCallPoll.setFlag(0);
				
				incomingCallPollJDBCTemplate.createIncomingCallPoll(incomingCallPoll);
			}
			catch (JMSException jmsEx_p)
			{
				String errMsg = "An error occurred extracting message";
			}
		}
		else
		{
			String errMsg = "Message is not of expected type TextMessage";
			throw new RuntimeException(errMsg);
		}
		
	}

}
