package org.com.sbm.cadence.common.dto;

import javax.persistence.CascadeType;
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
@Table(name = "user_rules")
public class UserRulesDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ruleId;
	
	@Column
	private boolean userManagement;
	
	@Column
	private boolean customerManagement;
	
	@Column
	private boolean lookupManagement;
	
	@Column
	private String canEdit;
	
	@Column
	private String canCreate;
	
	@Column
	private String canDelete;
	
	@Column
	private String canView;
	
	@Column
	private String lob;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sector", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunitySectorLookupDTO sector;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "region", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpportunityRegionLookupDTO region;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private UserRolesLookupDTO role;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
	private UsersDTO user;

	public UserRulesDTO() {}
	
	public UserRulesDTO(UsersDTO user, boolean userManagement, boolean customerManagement, boolean lookupManagement,
			String canEdit, String canCreate, String canDelete, String canView, String lob) {
		super();
		this.user = user;
		this.userManagement = userManagement;
		this.customerManagement = customerManagement;
		this.lookupManagement = lookupManagement;
		this.canEdit = canEdit;
		this.canCreate = canCreate;
		this.canDelete = canDelete;
		this.canView = canView;
		this.lob = lob;
	}

	public long getRuleId() {
		return ruleId;
	}

	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}

	public UsersDTO getUser() {
		return user;
	}

	public void setUser(UsersDTO user) {
		this.user = user;
	}

	public boolean isUserManagement() {
		return userManagement;
	}

	public void setUserManagement(boolean userManagement) {
		this.userManagement = userManagement;
	}

	public boolean isCustomerManagement() {
		return customerManagement;
	}

	public void setCustomerManagement(boolean customerManagement) {
		this.customerManagement = customerManagement;
	}

	public boolean isLookupManagement() {
		return lookupManagement;
	}

	public void setLookupManagement(boolean lookupManagement) {
		this.lookupManagement = lookupManagement;
	}

	public String getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(String canEdit) {
		this.canEdit = canEdit;
	}

	public String getCanCreate() {
		return canCreate;
	}

	public void setCanCreate(String canCreate) {
		this.canCreate = canCreate;
	}

	public String getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(String canDelete) {
		this.canDelete = canDelete;
	}

	public String getCanView() {
		return canView;
	}

	public void setCanView(String canView) {
		this.canView = canView;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
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

	public UserRolesLookupDTO getRole() {
		return role;
	}

	public void setRole(UserRolesLookupDTO role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRules [ruleId=" + ruleId + ", user=" + user + ", userManagement=" + userManagement
				+ ", customerManagement=" + customerManagement + ", lookupManagement=" + lookupManagement + ", canEdit="
				+ canEdit + ", canCreate=" + canCreate + ", canDelete=" + canDelete + ", canView=" + canView + ", lob="
				+ lob + ", sector=" + sector + ", region=" + region + ", role=" + role + "]";
	}
	
}
