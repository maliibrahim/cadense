package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opportunity_customer_need_lookup")
public class OpportunityCustomerNeedLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "customer_need", nullable = false)
	private String customerNeed;

	public OpportunityCustomerNeedLookupDTO() {}
	
	public OpportunityCustomerNeedLookupDTO(String customerNeed) {
		super();
		this.customerNeed = customerNeed;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getCustomerNeed() {
		return customerNeed;
	}

	public void setCustomerNeed(String customerNeed) {
		this.customerNeed = customerNeed;
	}

	@Override
	public String toString() {
		return "OpportunityCustomerNeedLookup [Id=" + Id + ", customerNeed=" + customerNeed + "]";
	}
}
