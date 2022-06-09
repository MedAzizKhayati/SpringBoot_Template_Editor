package com.travel.agent.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travel.agent.service.UserService;


import java.util.logging.Level; 
import java.util.logging.Logger; 

@Controller
public class MainController {

    @Autowired
	UserService userService;
    
    private static final Logger logger = Logger.getLogger(MainController.class.getName());

    
    @RequestMapping("/login")
	public String login() {
		
		logger.log(Level.INFO, "Redirect to login page");
        
		return "login";
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		
		logger.log(Level.INFO, "Redirect to home page");
    	
		return "index";
	}
	
	
	@RequestMapping("/accessdenied")
	public String accessdenied() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String id = ""; 
		if (auth.getPrincipal() instanceof UserDetails)
        	id = ((UserDetails) auth.getPrincipal()).getUsername();
        else if (auth.getPrincipal() instanceof String)
        	id = (String) auth.getPrincipal();

		return "accessdenied";
	}
}
