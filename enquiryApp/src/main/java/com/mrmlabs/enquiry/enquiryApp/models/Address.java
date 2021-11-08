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
@Table(name = "address")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
		@NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId"),
		@NamedQuery(name = "Address.findByDetail", query = "SELECT a FROM Address a WHERE a.detail = :detail"),
		@NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
		@NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country"),
		@NamedQuery(name = "Address.findByZip", query = "SELECT a FROM Address a WHERE a.zip = :zip") })
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "addressId")
	private Long addressId;
	@Size(max = 200)
	@Column(name = "detail")
	private String detail;
	@Size(max = 100)
	@Column(name = "city")
	private String city;
	@Size(max = 100)
	@Column(name = "country")
	private String country;
	@Column(name = "zip")
	private Integer zip;
	@OneToMany(mappedBy = "localAddress")
	private Collection<Contact> contactCollection;
	@OneToMany(mappedBy = "permanentAddress")
	private Collection<Contact> contactCollection1;

	public Address() {
	}

	public Address(Long addressId) {
		this.addressId = addressId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	@XmlTransient
	public Collection<Contact> getContactCollection() {
		return contactCollection;
	}

	public void setContactCollection(Collection<Contact> contactCollection) {
		this.contactCollection = contactCollection;
	}

	@XmlTransient
	public Collection<Contact> getContactCollection1() {
		return contactCollection1;
	}

	public void setContactCollection1(Collection<Contact> contactCollection1) {
		this.contactCollection1 = contactCollection1;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (addressId != null ? addressId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Address)) {
			return false;
		}
		Address other = (Address) object;
		if ((this.addressId == null && other.addressId != null)
				|| (this.addressId != null && !this.addressId.equals(other.addressId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.webappconcepts.models.Address[ addressId=" + addressId + " ]";
	}

}
