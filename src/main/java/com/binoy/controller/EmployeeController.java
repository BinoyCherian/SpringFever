package com.binoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myApp")
public class EmployeeController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void LoginCheck()
	{
		System.out.println("I am here");
	}

}
