package com.binoy.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.binoy.dao.Dao;
import com.binoy.pojo.Login;
import com.binoy.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	Dao dao;
		
	@Override
	public Boolean checkLogin(Login login) {

		boolean loginFlag=dao.getLogin(login);
		
		return loginFlag;
	}

}
