package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role_lookup")
public class UserRolesLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;
	
	@Column(name = "userRole", nullable = false)
	private String userRole;

	public UserRolesLookupDTO() {}
	
	public UserRolesLookupDTO(String userRole) {
		super();
		this.userRole = userRole;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRolesLookup [roleId=" + roleId + ", userRole=" + userRole + "]";
	}
}
