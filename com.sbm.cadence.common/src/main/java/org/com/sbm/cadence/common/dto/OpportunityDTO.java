package org.com.sbm.cadence.common.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "opportunity")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OpportunityDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long opportunityId;
		
	@Column
	private String 	salesRep;

	@Column
	private String 	OwnerName;

	@Column
	private String 	ommsysNumber;
	
	@Column
	private String 	opportunityName;
	
	@Column
	private String 	description;
	
	@Column
	private String 	odds;
	
	@Column
	private String 	so;
	
	@Column
	private String 	customerBudget;
		
	@Column
	private String 	customerAuth;
	
	@Column
	private String 	businessPartners;
	
	@Column
	private String sboNumber;
	
	@Column
	private String SBMChannel;
	
	@Column
	private Date expectedClosingDate;
	
	@Column
	private Date customerTiming;
	
	@Column
	private Date dueDate;
	
	@Column
	private boolean confidential;
	
	@Column
	private boolean SBO;	
	
//	@OneToMany(mappedBy = "opportunity", cascade = CascadeType.ALL)
//	private Set<OpportunityOrderDTO> order = new HashSet<>();
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "user_id", nullable = true)
	private UsersDTO users;

//    @OneToMany(mappedBy = "opportunityAttachmet", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Set<OpportunityAttachmentDTO> opportunityAttachments = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "type", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunityTypeLookupDTO opportunityType;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "source_id", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunitySourceLookupDTO opportunitySource;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "sector_id", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunitySectorLookupDTO sector;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "region", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunityRegionLookupDTO region;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "customer_need", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunityCustomerNeedLookupDTO customerNeed;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "status", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunityStatusLookupDTO status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "customer_id", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CustomerDTO customer;

//	@OneToMany(mappedBy = "opportunity", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	private Set<UserCommentsDTO> userComments = new HashSet<>();

	public OpportunityDTO() {}
	
	public OpportunityDTO(String salesRep, String ownerName, String ommsysNumber, String opportunityName,
			String description, String odds, String so, String customerBudget, String customerAuth,
			String businessPartners, String sboNumber, String sBMChannel, Date expectedClosingDate, Date customerTiming,
			Date dueDate, boolean confidential, boolean sBO) {
		super();
		this.salesRep = salesRep;
		OwnerName = ownerName;
		this.ommsysNumber = ommsysNumber;
		this.opportunityName = opportunityName;
		this.description = description;
		this.odds = odds;
		this.so = so;
		this.customerBudget = customerBudget;
		this.customerAuth = customerAuth;
		this.businessPartners = businessPartners;
		this.sboNumber = sboNumber;
		SBMChannel = sBMChannel;
		this.expectedClosingDate = expectedClosingDate;
		this.customerTiming = customerTiming;
		this.dueDate = dueDate;
		this.confidential = confidential;
		SBO = sBO;
	}

	public long getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(long opportunityId) {
		this.opportunityId = opportunityId;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}

	public String getOmmsysNumber() {
		return ommsysNumber;
	}

	public void setOmmsysNumber(String ommsysNumber) {
		this.ommsysNumber = ommsysNumber;
	}

	public String getOpportunityName() {
		return opportunityName;
	}

	public void setOpportunityName(String opportunityName) {
		this.opportunityName = opportunityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOdds() {
		return odds;
	}

	public void setOdds(String odds) {
		this.odds = odds;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getCustomerBudget() {
		return customerBudget;
	}

	public void setCustomerBudget(String customerBudget) {
		this.customerBudget = customerBudget;
	}

	public String getCustomerAuth() {
		return customerAuth;
	}

	public void setCustomerAuth(String customerAuth) {
		this.customerAuth = customerAuth;
	}

	public String getBusinessPartners() {
		return businessPartners;
	}

	public void setBusinessPartners(String businessPartners) {
		this.businessPartners = businessPartners;
	}

	public String getSboNumber() {
		return sboNumber;
	}

	public void setSboNumber(String sboNumber) {
		this.sboNumber = sboNumber;
	}

	public String getSBMChannel() {
		return SBMChannel;
	}

	public void setSBMChannel(String sBMChannel) {
		SBMChannel = sBMChannel;
	}

	public Date getExpectedClosingDate() {
		return expectedClosingDate;
	}

	public void setExpectedClosingDate(Date expectedClosingDate) {
		this.expectedClosingDate = expectedClosingDate;
	}

	public Date getCustomerTiming() {
		return customerTiming;
	}

	public void setCustomerTiming(Date customerTiming) {
		this.customerTiming = customerTiming;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isConfidential() {
		return confidential;
	}

	public void setConfidential(boolean confidential) {
		this.confidential = confidential;
	}

	public boolean isSBO() {
		return SBO;
	}

	public void setSBO(boolean sBO) {
		SBO = sBO;
	}

//	public Set<OpportunityOrderDTO> getOrder() {
//		return order;
//	}
//
//	public void setOrder(Set<OpportunityOrderDTO> order) {
//		this.order = order;
//	}

	public UsersDTO getUsers() {
		return users;
	}

	public void setUsers(UsersDTO users) {
		this.users = users;
	}

//	public Set<OpportunityAttachmentDTO> getOpportunityAttachments() {
//		return opportunityAttachments;
//	}
//
//	public void setOpportunityAttachments(Set<OpportunityAttachmentDTO> opportunityAttachments) {
//		this.opportunityAttachments = opportunityAttachments;
//	}

	public OpportunityTypeLookupDTO getOpportunityType() {
		return opportunityType;
	}

	public void setOpportunityType(OpportunityTypeLookupDTO opportunityType) {
		this.opportunityType = opportunityType;
	}

	public OpportunitySourceLookupDTO getOpportunitySource() {
		return opportunitySource;
	}

	public void setOpportunitySource(OpportunitySourceLookupDTO opportunitySource) {
		this.opportunitySource = opportunitySource;
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

	public OpportunityCustomerNeedLookupDTO getCustomerNeed() {
		return customerNeed;
	}

	public void setCustomerNeed(OpportunityCustomerNeedLookupDTO customerNeed) {
		this.customerNeed = customerNeed;
	}

	public OpportunityStatusLookupDTO getStatus() {
		return status;
	}

	public void setStatus(OpportunityStatusLookupDTO status) {
		this.status = status;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
//	public Set<UserCommentsDTO> getUserComments() {
//		return userComments;
//	}
//
//	public void setUserComments(Set<UserCommentsDTO> userComments) {
//		this.userComments = userComments;
//	}

	@Override
	public String toString() {
		return "Opportunity [opportunityId=" + opportunityId + ", salesRep=" + salesRep + ", OwnerName=" + OwnerName
				+ ", ommsysNumber=" + ommsysNumber + ", opportunityName=" + opportunityName + ", description="
				+ description + ", odds=" + odds + ", so=" + so + ", customerBudget=" + customerBudget
				+ ", customerAuth=" + customerAuth + ", businessPartners=" + businessPartners + ", sboNumber="
				+ sboNumber + ", SBMChannel=" + SBMChannel + ", expectedClosingDate=" + expectedClosingDate
				+ ", customerTiming=" + customerTiming + ", dueDate=" + dueDate + ", confidential=" + confidential
				+ ", SBO=" + SBO + ", users=" + users + ", opportunityType=" + opportunityType + ", opportunitySource="
				+ opportunitySource + ", sector=" + sector + ", region=" + region + ", customerNeed=" + customerNeed
				+ ", status=" + status + ", customer=" + customer + "]";
	}
	

}
