package com.modusbps.bos.crm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.modusbps.bos.entity.CRMCustomer;

public class CRMCustomerMapper implements RowMapper<CRMCustomer> {

	@Override
	public CRMCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CRMCustomer crmCustomer = new CRMCustomer();
		crmCustomer.setAccountId(rs.getInt("account_id"));
		crmCustomer.setContactFirstName(rs.getString("contact_first_name"));
		crmCustomer.setContactLastName(rs.getString("contact_last_name"));
		crmCustomer.setContactEmail(rs.getString("contact_email"));
		crmCustomer.setContactMobile(rs.getString("contact_mobile"));
		crmCustomer.setAccountName(rs.getString("account_name"));
		crmCustomer.setAccountCategory(rs.getString("account_category"));
		crmCustomer.setAccountPhone(rs.getString("account_phone"));
		
		return crmCustomer;
	}

}
