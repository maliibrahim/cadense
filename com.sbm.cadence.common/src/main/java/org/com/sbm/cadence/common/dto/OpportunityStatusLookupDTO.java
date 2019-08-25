package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opportunity_status_lookup")
public class OpportunityStatusLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long statusId;
	
	@Column(name = "status", nullable = false)
	private String status;

	public OpportunityStatusLookupDTO() {}
	
	public OpportunityStatusLookupDTO(String status) {
		super();
		this.status = status;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OpportunityStatusLookup [statusId=" + statusId + ", status=" + status + "]";
	}

}
