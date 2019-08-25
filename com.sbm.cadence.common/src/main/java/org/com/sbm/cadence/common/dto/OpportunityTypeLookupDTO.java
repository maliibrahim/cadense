package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opportunity_type_lookup")
public class OpportunityTypeLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long typeId;
	
	@Column(name = "type", nullable = false)
	private String type;

	public OpportunityTypeLookupDTO() {}
	
	public OpportunityTypeLookupDTO(String type) {
		super();
		this.type = type;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long opportunityId) {
		this.typeId = opportunityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "opportunity Type [Id=" + typeId + ", type=" + type + "]";
	}
	
}
