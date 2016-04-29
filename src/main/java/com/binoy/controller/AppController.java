package com.binoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.binoy.pojo.Login;
import com.binoy.validator.LoginFormValidator;

@Controller

public class AppController {
	
		
	@Autowired
	LoginFormValidator loginFormValidator;
	
	@InitBinder	
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(loginFormValidator);
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public String displayLogin(Model model) { 
	    model.addAttribute("login", new Login()); 
	    System.out.println("Returning index page");
	    return "index"; 
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void LoginCheck(@ModelAttribute("login") Login login,BindingResult result)
	{
		System.out.println("I am here");
		System.out.println("Login user name:"+login.getUsername());
		
		
	}

}
