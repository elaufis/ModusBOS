package com.modusbps.bos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.modusbps.bos.entity.Customer;
import com.modusbps.bos.entity.IndustryType;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		
		customer.setCustomerId(rs.getInt("account_id"));
		customer.setCustomerName(rs.getString("cust_name"));
		customer.setIndustryType(getIndustryTypeFromDescription(rs.getString("industry_type")));
		customer.setOfficePhoneNumber(rs.getString("office_phone_number"));
		customer.setMobilePhoneNumber(rs.getString("mobile_phone_number"));
		customer.setAssignedSalesRep(rs.getString("assigned_sales_rep"));
		
		return customer;
	}
	
	private IndustryType getIndustryTypeFromDescription(String industryDescription){
		for(IndustryType type: IndustryType.values()){
			if(type.getDescription().equals(industryDescription)){
				return type;
			}
		}
		return IndustryType.OTHER;
	}

}
