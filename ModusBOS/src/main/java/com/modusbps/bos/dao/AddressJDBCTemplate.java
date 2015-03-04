package com.modusbps.bos.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.modusbps.bos.entity.Address;

public class AddressJDBCTemplate extends JDBCTemplate implements AddressDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public AddressJDBCTemplate() {
		super.setDataSource(dataSource);
	}
	
	@Override
	public List<Address> getAllAddressesForCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomerAddress(Address address) {
		// TODO Auto-generated method stub

	}

}
