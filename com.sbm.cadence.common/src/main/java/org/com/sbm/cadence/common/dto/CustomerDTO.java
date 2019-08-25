package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Customers")
public class CustomerDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;

	@Column
	private String email;

	@Column
	private String 	customerNumber;

	@Column
	private String 	customerName;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sector", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunitySectorLookupDTO sector;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "region", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunityRegionLookupDTO region;

	public CustomerDTO() {}
	
	public CustomerDTO(String email, String customerNumber, String customerName) {
		super();
		this.email = email;
		this.customerNumber = customerNumber;
		this.customerName = customerName;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public OpportunitySectorLookupDTO getSector() {
		return sector;
	}

	public void setSector(OpportunitySectorLookupDTO sector) {
		this.sector = sector;
	}

	public OpportunityRegionLookupDTO getRegion() {
		return region;
	}

	public void setRegion(OpportunityRegionLookupDTO region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", email=" + email + ", customerNumber=" + customerNumber
				+ ", customerName=" + customerName + "]";
	}
	
}
