package com.binoy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.binoy.dbConfig.DbConfig;
import com.binoy.pojo.Login;

@Component
public class Dao implements DaoInterface {
	
	@Autowired
	DbConfig config;

	@Override
	public boolean getLogin(Login login) {
		
		boolean loginFlag=false;
		
		Login loginObjectFromDb=config.getJdbcTemplate().queryForObject("select userid,userpassword from adminLoginusers where userid='"
				+login.getUsername()+"'", new RowMapper<Login>(){

					@Override
					public Login mapRow(ResultSet rs, int num) throws SQLException {
						Login loginDb=new Login();
						loginDb.setUsername(rs.getString("userid"));
						loginDb.setPassword(rs.getString("userpassword"));
						return loginDb;
					}
			
		});
		
		if(loginObjectFromDb==null||loginObjectFromDb.equals(null))
		{
			System.out.println("Not Found in Db");
			loginFlag=false;
		}
		
		else
			loginFlag=checkAdmin(login,loginObjectFromDb);

		
		return loginFlag;
	}
	
	 private boolean checkAdmin(Login login, Login loginObjectFromDb) {
		
		return login.getUsername().equalsIgnoreCase(loginObjectFromDb.getUsername())&&login.getPassword().equalsIgnoreCase(loginObjectFromDb.getPassword());
	}

	
}
