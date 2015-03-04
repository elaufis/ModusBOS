package com.modusbps.bos.dao;

import java.util.List;

import javax.sql.DataSource;

import com.modusbps.bos.entity.IncomingCallPoll;

public interface IncomingCallPollDAO {
	
	public void setDataSource(DataSource dataSource);
	
	public IncomingCallPoll getIncomingCallPollByID(String id);
	
	public void createIncomingCallPoll(IncomingCallPoll incomingCallPoll);
	
	public List<IncomingCallPoll> getIncomingCallPollByPhoneNumber(String phoneNumber);

}
