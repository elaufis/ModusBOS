package com.modusbps.bos.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class BOSIncomingCallMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage)
		{
			try
			{
				String msgText = ((TextMessage) message).getText();
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
