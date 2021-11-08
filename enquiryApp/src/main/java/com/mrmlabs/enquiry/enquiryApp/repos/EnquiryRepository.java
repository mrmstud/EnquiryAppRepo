package com.mrmlabs.enquiry.enquiryApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrmlabs.enquiry.enquiryApp.models.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

}
