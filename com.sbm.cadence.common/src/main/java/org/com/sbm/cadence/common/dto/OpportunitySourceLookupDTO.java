package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opportunity_source_lookup")
public class OpportunitySourceLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sourceId;
	
	@Column(name = "source", nullable = false)
	private String source;

	public OpportunitySourceLookupDTO() {
		
	}
	public OpportunitySourceLookupDTO(String source) {
		super();
		this.source = source;
	}

	public long getSourceId() {
		return sourceId;
	}


	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "LicenseType [opportunityId=" + sourceId+ ", type=" + source + "]";
	}
	
}
