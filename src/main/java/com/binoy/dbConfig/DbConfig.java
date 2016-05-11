package com.binoy.dbConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);

	}
}
