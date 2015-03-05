package com.modusbps.bos.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.modusbps.bos.entity.CustomerContact;

public class CustomerContactJDBCTemplate implements CustomerContactDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public CustomerContact getCustomerByMSISDN(String msisdn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomerContact(CustomerContact customerContact) {
		String sql = "INSERT INTO customer_contact(cust_id,contact_first_name,contact_last_name,title,mobile_phone_number,email_address) VALUES (?,?,?,?,?,?)";
		
		jdbcTemplateObject.update(sql, customerContact.getCustomerId(), customerContact.getCustomerFirstName(), customerContact.getCustomerLastName(), customerContact.getTitle(), customerContact.getMobilePhoneNumber(), customerContact.getEmailAddress());

	}

	@Override
	public List<CustomerContact> getCustomerContactsByCustomerId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

}
