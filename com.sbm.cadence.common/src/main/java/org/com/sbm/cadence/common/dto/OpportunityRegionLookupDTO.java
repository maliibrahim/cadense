package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opportunity_region_lookup")
public class OpportunityRegionLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long regionId;
	
	@Column(name = "region", nullable = false)
	private String region;

	public OpportunityRegionLookupDTO() {} 
	
	public OpportunityRegionLookupDTO(String region) {
		super();
		this.region = region;
	}

	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "OpportunityRegionLookup [regionId=" + regionId + ", region=" + region + "]";
	}
}
