/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrmlabs.enquiry.enquiryApp.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SamGrishma
 */
@Entity
@Table(name = "enquirycourse")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EnquiryCourse.findAll", query = "SELECT e FROM EnquiryCourse e"),
		@NamedQuery(name = "EnquiryCourse.findByEnquiryCourseId", query = "SELECT e FROM EnquiryCourse e WHERE e.enquiryCourseId = :enquiryCourseId") })
public class EnquiryCourse implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "enquiryCourseId")
	private Long enquiryCourseId;
	@JoinColumn(name = "courseId", referencedColumnName = "courseId")
	@ManyToOne
	private Course courseId;
	@JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
	@ManyToOne
	private Enquiry enquiryId;

	public EnquiryCourse() {
	}

	public EnquiryCourse(Long enquiryCourseId) {
		this.enquiryCourseId = enquiryCourseId;
	}

	public Long getEnquiryCourseId() {
		return enquiryCourseId;
	}

	public void setEnquiryCourseId(Long enquiryCourseId) {
		this.enquiryCourseId = enquiryCourseId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public Enquiry getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Enquiry enquiryId) {
		this.enquiryId = enquiryId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (enquiryCourseId != null ? enquiryCourseId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof EnquiryCourse)) {
			return false;
		}
		EnquiryCourse other = (EnquiryCourse) object;
		if ((this.enquiryCourseId == null && other.enquiryCourseId != null)
				|| (this.enquiryCourseId != null && !this.enquiryCourseId.equals(other.enquiryCourseId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.webappconcepts.models.Enquirycourse[ enquiryCourseId=" + enquiryCourseId + " ]";
	}

}
