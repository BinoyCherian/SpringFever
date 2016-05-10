package com.binoy.service;

import org.springframework.stereotype.Component;

import com.binoy.pojo.Login;

@Component
public interface LoginService {

	public Boolean checkLogin(Login login);
}
