package com.jda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jda.model.UserModel;
import com.jda.service.IUserService;

@Controller

public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value = "/index")
	public ModelAndView startupPage(){
		ModelAndView model = new ModelAndView("Login");
		return model;
	}
	
	@RequestMapping(value = "/registration")
	public ModelAndView regPage(){
		ModelAndView model = new ModelAndView("Registration");
		return model;
	}
	
	@RequestMapping(value = "/data")
	public ModelAndView takeData(@ModelAttribute("NewUser") UserModel model){
		if(userService.registerUser(model))
			return new ModelAndView("Login");
		return null;
	}
	
	@RequestMapping(value = "/forgot")
	public ModelAndView forgotPage(){
		ModelAndView model = new ModelAndView("ForgotPass");
		return model;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@ModelAttribute("User") UserModel model){
		System.out.println(model.getEmail());
		return new ModelAndView("sample");
	}
}
