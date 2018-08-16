package com.jda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
	
	@RequestMapping(value = "/")
	public ModelAndView startupPage(){
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(value = "/registration")
	public ModelAndView regPage(){
		ModelAndView model = new ModelAndView("Registration");
		return model;
	}
	
	@RequestMapping(value = "forgot")
	public ModelAndView forgotPage(){
		ModelAndView model = new ModelAndView("ForgotPass");
		return model;
	}
	
}
