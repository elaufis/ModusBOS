package com.modusbps.bos.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.modusbps.bos.entity.Customer;

public class CustomerJDBCTemplate implements CustomerDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	@Override
	public Customer getCustomerByMSISDN(String msisdn) {
		String sql = "SELECT * FROM Customer WHERE mobile_phone_number = ?";
//		jdbcTemplateObject.
		return null;
	}

	@Override
	public void createCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(cust_id, cust_name, category, office_phone_number) VALUES (?,?,?,?)";
		
		jdbcTemplateObject.update(sql, customer.getCustomerId(), customer.getCustomerName(), customer.getCategory(), customer.getOfficePhoneNumber());

	}

	@Override
	public List<Customer> getCustomersByRep(String repNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
