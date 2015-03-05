package com.modusbps.bos.crm.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.modusbps.bos.entity.CRMCustomer;

public class CRMCustomerJDBCTemplate implements CRMCustomerDetailDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public CRMCustomer getCustomerByMSISDN(String msisdn) {
		String sql = "select accounts.id as account_id, contacts.first_name as contact_first_name," +
				"contacts.last_name as contact_last_name," +
				"contacts.email as contact_email," +
				"contacts.title as contact_title," +
				"contacts.mobile as contact_mobile," +
				"accounts.name as account_name," +
				"accounts.category as account_category," +
				"accounts.phone as account_phone " + 
				"from contacts inner join account_contacts a on contacts.id = a.contact_id " +
				"inner join accounts on a.account_id = accounts.id " +
				"where contacts.mobile = ?";

		CRMCustomer crmCustomer  = jdbcTemplateObject.queryForObject(sql, new Object[]{msisdn}, new CRMCustomerMapper());

		return crmCustomer;
	}

	@Override
	public List<CRMCustomer> getCustomerContactsByCustomerId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

}
