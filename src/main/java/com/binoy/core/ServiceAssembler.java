package com.binoy.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.binoy.service.LoginService;
import com.binoy.serviceImpl.LoginServiceImpl;

@Component
public class ServiceAssembler {

	@Autowired
	LoginServiceImpl loginServiceImpl;

	public LoginService newInstance() {
		
		return loginServiceImpl;

	}

}
