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
@Table(name = "contact")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
		@NamedQuery(name = "Contact.findByContactId", query = "SELECT c FROM Contact c WHERE c.contactId = :contactId"),
		@NamedQuery(name = "Contact.findByName", query = "SELECT c FROM Contact c WHERE c.name = :name"),
		@NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email"),
		@NamedQuery(name = "Contact.findByPhone", query = "SELECT c FROM Contact c WHERE c.phone = :phone") })
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "contactId")
	private Long contactId;
	@Size(max = 45)
	@Column(name = "name")
	private String name;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using
	// this annotation to enforce field validation
	@Size(max = 45)
	@Column(name = "email")
	private String email;
	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field
	// contains phone or fax number consider using this annotation to enforce field
	// validation
	@Size(max = 100)
	@Column(name = "phone")
	private String phone;
	@JoinColumn(name = "localAddress", referencedColumnName = "addressId")
	@ManyToOne
	private Address localAddress;
	@JoinColumn(name = "permanentAddress", referencedColumnName = "addressId")
	@ManyToOne
	private Address permanentAddress;
	@OneToMany(mappedBy = "contactId")
	private Collection<Enquiry> enquiryCollection;
	@OneToMany(mappedBy = "contactId")
	private Collection<Institute> instituteCollection;

	public Contact() {
	}

	public Contact(Long contactId) {
		this.contactId = contactId;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(Address localAddress) {
		this.localAddress = localAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@XmlTransient
	public Collection<Enquiry> getEnquiryCollection() {
		return enquiryCollection;
	}

	public void setEnquiryCollection(Collection<Enquiry> enquiryCollection) {
		this.enquiryCollection = enquiryCollection;
	}

	@XmlTransient
	public Collection<Institute> getInstituteCollection() {
		return instituteCollection;
	}

	public void setInstituteCollection(Collection<Institute> instituteCollection) {
		this.instituteCollection = instituteCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (contactId != null ? contactId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Contact)) {
			return false;
		}
		Contact other = (Contact) object;
		if ((this.contactId == null && other.contactId != null)
				|| (this.contactId != null && !this.contactId.equals(other.contactId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.webappconcepts.models.Contact[ contactId=" + contactId + " ]";
	}

}
