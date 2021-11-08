package com.mrmlabs.enquiry.enquiryApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 *
 */
public interface EnquiryDto {

    Long getEnquiryId();

    String getPhone();

    String getName();

    String getCourses(); //comma separated

    Integer getFollowUpCount();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    Date getDoe();

    Float getFees();
}
