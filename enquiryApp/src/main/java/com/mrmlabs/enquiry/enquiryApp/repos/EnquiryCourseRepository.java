package com.mrmlabs.enquiry.enquiryApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrmlabs.enquiry.enquiryApp.models.EnquiryCourse;

@Repository
public interface EnquiryCourseRepository extends JpaRepository<EnquiryCourse, Long> {

}
