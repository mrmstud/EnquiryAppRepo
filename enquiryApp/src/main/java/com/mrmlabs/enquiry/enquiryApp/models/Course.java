/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrmlabs.enquiry.enquiryApp.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SamGrishma
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
		@NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
		@NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
		@NamedQuery(name = "Course.findByFees", query = "SELECT c FROM Course c WHERE c.fees = :fees") })
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "courseId")
	private Long courseId;
	@Size(max = 100)
	@Column(name = "name")
	private String name;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "fees")
	private Double fees;
	@OneToMany(mappedBy = "courseId")
	private Collection<EnquiryCourse> enquirycourseCollection;
	@JoinColumn(name = "instituteId", referencedColumnName = "instituteId")
	@ManyToOne
	private Institute instituteId;

	public Course() {
	}

	public Course(Long courseId) {
		this.courseId = courseId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	@XmlTransient
	public Collection<EnquiryCourse> getEnquirycourseCollection() {
		return enquirycourseCollection;
	}

	public void setEnquirycourseCollection(Collection<EnquiryCourse> enquirycourseCollection) {
		this.enquirycourseCollection = enquirycourseCollection;
	}

	public Institute getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Institute instituteId) {
		this.instituteId = instituteId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (courseId != null ? courseId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Course)) {
			return false;
		}
		Course other = (Course) object;
		if ((this.courseId == null && other.courseId != null)
				|| (this.courseId != null && !this.courseId.equals(other.courseId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.webappconcepts.models.Course[ courseId=" + courseId + " ]";
	}

}
