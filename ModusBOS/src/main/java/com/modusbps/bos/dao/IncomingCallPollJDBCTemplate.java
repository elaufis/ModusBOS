package com.modusbps.bos.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.modusbps.bos.entity.IncomingCallPoll;

public class IncomingCallPollJDBCTemplate implements IncomingCallPollDAO {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public IncomingCallPoll getIncomingCallPollByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createIncomingCallPoll(IncomingCallPoll incomingCallPoll) {
		String sql = "INSERT INTO incoming_call_poll(id,data,description,type,flag,insert_datetime) VALUES (?,?,?,?,?,?)";

		java.util.Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		
		jdbcTemplateObject.update(sql, incomingCallPoll.getId(), incomingCallPoll.getData(), incomingCallPoll.getDescription(), incomingCallPoll.getType(), incomingCallPoll.getFlag(), timestamp);
	}

	@Override
	public List<IncomingCallPoll> getIncomingCallPollByPhoneNumber(
			String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
