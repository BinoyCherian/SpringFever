package com.binoy.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.binoy.pojo.Login;
import com.binoy.service.LoginService;

@Component
public class LoginFormValidator implements Validator{

	@Autowired
	LoginService loginService;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Login.class.equals(clazz);
		
	 }

	@Override
	public void validate(Object target, Errors errors) {
		
		Login login=(Login) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userForm.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
		
				
	}

}
