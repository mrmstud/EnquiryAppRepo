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
@Table(name = "enquirysource")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EnquirySource.findAll", query = "SELECT e FROM EnquirySource e"),
		@NamedQuery(name = "EnquirySource.findByEnquirySourceId", query = "SELECT e FROM EnquirySource e WHERE e.enquirySourceId = :enquirySourceId"),
		@NamedQuery(name = "EnquirySource.findByName", query = "SELECT e FROM EnquirySource e WHERE e.name = :name") })
public class EnquirySource implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "enquirySourceId")
	private Long enquirySourceId;
	@Size(max = 100)
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "enquirySourceId")
	private Collection<Enquiry> enquiryCollection;

	public EnquirySource() {
	}

	public EnquirySource(Long enquirySourceId) {
		this.enquirySourceId = enquirySourceId;
	}

	public Long getEnquirySourceId() {
		return enquirySourceId;
	}

	public void setEnquirySourceId(Long enquirySourceId) {
		this.enquirySourceId = enquirySourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public Collection<Enquiry> getEnquiryCollection() {
		return enquiryCollection;
	}

	public void setEnquiryCollection(Collection<Enquiry> enquiryCollection) {
		this.enquiryCollection = enquiryCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (enquirySourceId != null ? enquirySourceId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof EnquirySource)) {
			return false;
		}
		EnquirySource other = (EnquirySource) object;
		if ((this.enquirySourceId == null && other.enquirySourceId != null)
				|| (this.enquirySourceId != null && !this.enquirySourceId.equals(other.enquirySourceId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.webappconcepts.models.Enquirysource[ enquirySourceId=" + enquirySourceId + " ]";
	}

}
