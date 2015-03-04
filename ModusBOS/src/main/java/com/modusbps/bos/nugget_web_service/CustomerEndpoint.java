package com.modusbps.bos.nugget_web_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.modusbps.bos.dao.CustomerDAO;
import com.modusbps.bos.dao.CustomerJDBCTemplate;
import com.modusbps.bos.entity.Customer;

@Endpoint
public class CustomerEndpoint {
	private static final String NAMESPACE_URI = "http://modusbps.com/bos/nugget-web-service";
	
	private Customer customer;
	
	@Autowired
	public CustomerEndpoint(Customer customer){
		this.customer = customer;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCustomerRequest")
	@ResponsePayload
	public String createCustomer(@RequestPayload CreateCustomerRequest request){
		try {
			CustomerDAO customerDao = new CustomerJDBCTemplate();
			customerDao.createCustomer(this.customer);
			
			return("Successfully created customer");
		} catch (Exception e) {
			return("Could not create customer");
		}
	}
}
