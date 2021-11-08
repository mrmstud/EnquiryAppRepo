/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrmlabs.enquiry.enquiryApp.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SamGrishma
 */
@Entity
@Table(name = "institute")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Institute.findAll", query = "SELECT i FROM Institute i"),
		@NamedQuery(name = "Institute.findByInstituteId", query = "SELECT i FROM Institute i WHERE i.instituteId = :instituteId"),
		@NamedQuery(name = "Institute.findByName", query = "SELECT i FROM Institute i WHERE i.name = :name"),
		@NamedQuery(name = "Institute.findByDoe", query = "SELECT i FROM Institute i WHERE i.doe = :doe") })
public class Institute implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "instituteId")
	private Long instituteId;
	@Size(max = 200)
	@Column(name = "name")
	private String name;
	@Column(name = "doe")
	@Temporal(TemporalType.TIMESTAMP)
	private Date doe;
	@OneToMany(mappedBy = "instituteId")
	private Collection<Course> courseCollection;
	@OneToMany(mappedBy = "instituteId")
	private Collection<Enquiry> enquiryCollection;
	@JoinColumn(name = "contactId", referencedColumnName = "contactId")
	@ManyToOne
	private Contact contactId;

	public Institute() {
	}

	public Institute(Long instituteId) {
		this.instituteId = instituteId;
	}

	public Long getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Long instituteId) {
		this.instituteId = instituteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	@XmlTransient
	public Collection<Course> getCourseCollection() {
		return courseCollection;
	}

	public void setCourseCollection(Collection<Course> courseCollection) {
		this.courseCollection = courseCollection;
	}

	@XmlTransient
	public Collection<Enquiry> getEnquiryCollection() {
		return enquiryCollection;
	}

	public void setEnquiryCollection(Collection<Enquiry> enquiryCollection) {
		this.enquiryCollection = enquiryCollection;
	}

	public Contact getContactId() {
		return contactId;
	}

	public void setContactId(Contact contactId) {
		this.contactId = contactId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (instituteId != null ? instituteId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Institute)) {
			return false;
		}
		Institute other = (Institute) object;
		if ((this.instituteId == null && other.instituteId != null)
				|| (this.instituteId != null && !this.instituteId.equals(other.instituteId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.webappconcepts.models.Institute[ instituteId=" + instituteId + " ]";
	}

}
