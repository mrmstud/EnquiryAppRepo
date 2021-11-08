/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrmlabs.enquiry.enquiryApp.models;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SamGrishma
 */
@Entity
@Table(name = "followup")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Followup.findAll", query = "SELECT f FROM Followup f"),
		@NamedQuery(name = "Followup.findByFollowupId", query = "SELECT f FROM Followup f WHERE f.followupId = :followupId"),
		@NamedQuery(name = "Followup.findByDoe", query = "SELECT f FROM Followup f WHERE f.doe = :doe"),
		@NamedQuery(name = "Followup.findByDetail", query = "SELECT f FROM Followup f WHERE f.detail = :detail") })
public class Followup implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "followupId")
	private Long followupId;
	@Column(name = "doe")
	@Temporal(TemporalType.TIMESTAMP)
	private Date doe;
	@Size(max = 200)
	@Column(name = "detail")
	private String detail;
	@JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
	@ManyToOne
	private Enquiry enquiryId;

	public Followup() {
	}

	public Followup(Long followupId) {
		this.followupId = followupId;
	}

	public Long getFollowupId() {
		return followupId;
	}

	public void setFollowupId(Long followupId) {
		this.followupId = followupId;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
		hash += (followupId != null ? followupId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Followup)) {
			return false;
		}
		Followup other = (Followup) object;
		if ((this.followupId == null && other.followupId != null)
				|| (this.followupId != null && !this.followupId.equals(other.followupId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.webappconcepts.models.Followup[ followupId=" + followupId + " ]";
	}

}
