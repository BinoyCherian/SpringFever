package com.binoy.dbConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class DataSourceBean {

	@Bean
	public DataSource dataSource() {

		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL) // .H2 or
																		// .DERBY
				.addScript("db/sql/create-db.sql").addScript("db/sql/insert-data.sql").build();
		return db;
	}

//	@PostConstruct
//	public void startDBManager() {
//		
//		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
//
//		
//	}
	
}
