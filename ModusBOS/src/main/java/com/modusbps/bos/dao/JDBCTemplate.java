package com.modusbps.bos.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class JDBCTemplate {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	@SuppressWarnings("unused")
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}
