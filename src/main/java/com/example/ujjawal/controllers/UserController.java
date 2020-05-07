package com.example.ujjawal.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ujjawal.entities.user;
import com.example.ujjawal.repo.UserRepository;
import com.example.ujjawal.services.SecurityService;

@Controller
public class UserController {
	@Autowired
	private SecurityService securityService;
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage()
	{
		return "login/registerUser";
	}
	@RequestMapping(value="/showLogin")
	public String register()
	{
		
		return "login/login";
		
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") user user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap)
	{
		boolean loginResponse=securityService.login(email, password);
		if(loginResponse)
		  return "findFlights";
		else
		{
			modelMap.addAttribute("msg","Invalid user name or password.Please try again.");
		}
		return "login/login";
		
	}
	

}
