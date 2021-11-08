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
@Table(name = "enquiry")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Enquiry.findAll", query = "SELECT e FROM Enquiry e"),
		@NamedQuery(name = "Enquiry.findByEnquiryId", query = "SELECT e FROM Enquiry e WHERE e.enquiryId = :enquiryId"),
		@NamedQuery(name = "Enquiry.findByDoe", query = "SELECT e FROM Enquiry e WHERE e.doe = :doe"),
		@NamedQuery(name = "Enquiry.findByNextCallDate", query = "SELECT e FROM Enquiry e WHERE e.nextCallDate = :nextCallDate"),
		@NamedQuery(name = "Enquiry.findByRemark", query = "SELECT e FROM Enquiry e WHERE e.remark = :remark"),
		@NamedQuery(name = "Enquiry.findByCommittedFees", query = "SELECT e FROM Enquiry e WHERE e.committedFees = :committedFees"),
		@NamedQuery(name = "Enquiry.findByLastUpdate", query = "SELECT e FROM Enquiry e WHERE e.lastUpdate = :lastUpdate") })
public class Enquiry implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "enquiryId")
	private Long enquiryId;
	@Column(name = "doe")
	@Temporal(TemporalType.TIMESTAMP)
	private Date doe;
	@Column(name = "nextCallDate")
	@Temporal(TemporalType.DATE)
	private Date nextCallDate;
	@Size(max = 400)
	@Column(name = "remark")
	private String remark;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "committedFees")
	private Double committedFees;
	@Column(name = "lastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	@OneToMany(mappedBy = "enquiryId")
	private Collection<Followup> followupCollection;
	@OneToMany(mappedBy = "enquiryId")
	private Collection<EnquiryCourse> enquirycourseCollection;
	@JoinColumn(name = "contactId", referencedColumnName = "contactId")
	@ManyToOne
	private Contact contactId;
	@JoinColumn(name = "enquirySourceId", referencedColumnName = "enquirySourceId")
	@ManyToOne
	private EnquirySource enquirySourceId;
	@JoinColumn(name = "instituteId", referencedColumnName = "instituteId")
	@ManyToOne
	private Institute instituteId;

	public Enquiry() {
	}

	public Enquiry(Long enquiryId) {
		this.enquiryId = enquiryId;
	}

	public Long getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Long enquiryId) {
		this.enquiryId = enquiryId;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public Date getNextCallDate() {
		return nextCallDate;
	}

	public void setNextCallDate(Date nextCallDate) {
		this.nextCallDate = nextCallDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getCommittedFees() {
		return committedFees;
	}

	public void setCommittedFees(Double committedFees) {
		this.committedFees = committedFees;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@XmlTransient
	public Collection<Followup> getFollowupCollection() {
		return followupCollection;
	}

	public void setFollowupCollection(Collection<Followup> followupCollection) {
		this.followupCollection = followupCollection;
	}

	@XmlTransient
	public Collection<EnquiryCourse> getEnquirycourseCollection() {
		return enquirycourseCollection;
	}

	public void setEnquirycourseCollection(Collection<EnquiryCourse> enquirycourseCollection) {
		this.enquirycourseCollection = enquirycourseCollection;
	}

	public Contact getContactId() {
		return contactId;
	}

	public void setContactId(Contact contactId) {
		this.contactId = contactId;
	}

	public EnquirySource getEnquirySourceId() {
		return enquirySourceId;
	}

	public void setEnquirySourceId(EnquirySource enquirySourceId) {
		this.enquirySourceId = enquirySourceId;
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
		hash += (enquiryId != null ? enquiryId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Enquiry)) {
			return false;
		}
		Enquiry other = (Enquiry) object;
		if ((this.enquiryId == null && other.enquiryId != null)
				|| (this.enquiryId != null && !this.enquiryId.equals(other.enquiryId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.webappconcepts.models.Enquiry[ enquiryId=" + enquiryId + " ]";
	}

}
