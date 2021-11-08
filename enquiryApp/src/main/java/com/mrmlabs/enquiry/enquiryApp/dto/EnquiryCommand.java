package com.mrmlabs.enquiry.enquiryApp.dto;

import com.mrmlabs.enquiry.enquiryApp.models.Enquiry;

/**
 */
public class EnquiryCommand {
    Enquiry enquiry;
    Long[] courses;

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    public Long[] getCourses() {
        return courses;
    }

    public void setCourses(Long[] courses) {
        this.courses = courses;
    }
    
    
}
