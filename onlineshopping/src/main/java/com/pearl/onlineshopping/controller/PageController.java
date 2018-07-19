package com.pearl.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/","/index"})
	public ModelAndView index() {
		
		ModelAndView mView =new ModelAndView("page");
		
		mView.addObject("message","Hollo Amer");
		
		return mView;
	}

}
