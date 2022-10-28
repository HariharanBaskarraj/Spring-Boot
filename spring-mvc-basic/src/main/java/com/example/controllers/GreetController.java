package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	@RequestMapping("greet")
	public String greetUser(Model model) {
		String message = "Have a good day!!!";
		// attach data to model
		// first argument is dummy name
		// second argument is original data
		model.addAttribute("message", message);
		// return the name that points to the jsp file
		return "success";
	}
	
	@RequestMapping("hello")
	public String sayHello(ModelMap map) {
		map.addAttribute("message","Hi... Hello..");
		return "success";
	}
	
	@RequestMapping("welcome")
	public ModelAndView welcomeUser() {
		ModelAndView modelView = new ModelAndView ("success", "message", "Welcome to MVC");
		return modelView;
	}
}
