package com.mrmlabs.enquiry.enquiryApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrmlabs.enquiry.enquiryApp.models.EnquirySource;
import com.mrmlabs.enquiry.enquiryApp.repos.EnquirySourceRepository;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	EnquirySourceRepository enquirySourceRepository;
	
	@GetMapping("/addSource")
	public void saveSource() {
		EnquirySource enquirySource = new EnquirySource();
		enquirySource.setName("Yahoo");
		enquirySourceRepository.save(enquirySource);
	}

}
