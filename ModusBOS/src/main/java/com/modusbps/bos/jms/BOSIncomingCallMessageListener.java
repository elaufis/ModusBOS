package com.modusbps.bos.jms;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modusbps.bos.crm.dao.CRMCustomerJDBCTemplate;
import com.modusbps.bos.dao.CustomerContactJDBCTemplate;
import com.modusbps.bos.dao.CustomerJDBCTemplate;
import com.modusbps.bos.dao.IncomingCallPollJDBCTemplate;
import com.modusbps.bos.entity.CRMCustomer;
import com.modusbps.bos.entity.Customer;
import com.modusbps.bos.entity.CustomerContact;
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
				
				createCustomerFromCRM(msisdn, context);
				
				createIncomingCallPollRecord(msgMap, context);

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
	
	private void createCustomerFromCRM(String msisdn, ApplicationContext context){
		// First get the data from the CRM - this includes account and contact data.
		CRMCustomerJDBCTemplate crmCustomerJDBCTemplate = (CRMCustomerJDBCTemplate)context.getBean("crmCustomerJDBCTemplate");
		CRMCustomer crmCustomer = crmCustomerJDBCTemplate.getCustomerByMSISDN(msisdn);
		
		// Transform the CRMCustomer to Customer
		Customer customer = new Customer();
		customer.setCustomerId(crmCustomer.getAccountId());
		customer.setCustomerName(crmCustomer.getAccountName());
		customer.setCategory(crmCustomer.getAccountCategory());
		customer.setOfficePhoneNumber(crmCustomer.getAccountPhone());
		
		// Insert the customer data into bosnugget database.
		CustomerJDBCTemplate customerJDBCTemplate = (CustomerJDBCTemplate)context.getBean("customerJDBCTemplate");
		customerJDBCTemplate.createCustomer(customer);
		
		// Create the Customer Contact
		CustomerContact customerContact = new CustomerContact();
		customerContact.setCustomerFirstName(crmCustomer.getContactFirstName());
		customerContact.setCustomerLastName(crmCustomer.getContactLastName());
		customerContact.setEmailAddress(crmCustomer.getContactEmail());
		
		CustomerContactJDBCTemplate customerContactJDBCTemplate = (CustomerContactJDBCTemplate)context.getBean("");
		customerContactJDBCTemplate.createCustomerContact(customerContact);
	}
	
	private void createIncomingCallPollRecord(Map<String, String> messageMap, ApplicationContext context){
		IncomingCallPollJDBCTemplate incomingCallPollJDBCTemplate = (IncomingCallPollJDBCTemplate)context.getBean("incomingCallPollJDBCTemplate");
		
		IncomingCallPoll incomingCallPoll = new IncomingCallPoll();
		incomingCallPoll.setId(messageMap.get("id"));
		incomingCallPoll.setData(messageMap.get("data"));
		incomingCallPoll.setDescription(messageMap.get("description"));
		incomingCallPoll.setType(messageMap.get("type"));
		incomingCallPoll.setFlag(0);
		
		incomingCallPollJDBCTemplate.createIncomingCallPoll(incomingCallPoll);
	}

}
