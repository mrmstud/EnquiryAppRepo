package com.mrmlabs.enquiry.enquiryApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "home"; //returns index.html page
	}

}
