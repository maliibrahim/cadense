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
@Table(name = "opportunity_Order")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OpportunityOrderDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@Column
	private String orderPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
	private OpportunityDTO opportunity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "product")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProductDTO opportunityProduct;

	@Column
	private boolean swgServiceAssetIncluded;
	
	@Column
	private String swgServiceAssetName; 
	 
	@Column
	private String swgServiceAssetVersion;	 

	@Column
	private String swgServiceAssetId;
	
	@Column
	private String stgServiceName;
	
	@Column
	private String stgServiceValue;

	public OpportunityOrderDTO() {}
	
	public OpportunityOrderDTO(String orderPrice, OpportunityDTO opportunity, ProductDTO opportunityProduct,
			boolean swgServiceAssetIncluded, String swgServiceAssetName, String swgServiceAssetVersion,
			String swgServiceAssetId, String stgServiceName, String stgServiceValue) {
		super();
		this.orderPrice = orderPrice;
		this.opportunity = opportunity;
		this.opportunityProduct = opportunityProduct;
		this.swgServiceAssetIncluded = swgServiceAssetIncluded;
		this.swgServiceAssetName = swgServiceAssetName;
		this.swgServiceAssetVersion = swgServiceAssetVersion;
		this.swgServiceAssetId = swgServiceAssetId;
		this.stgServiceName = stgServiceName;
		this.stgServiceValue = stgServiceValue;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public OpportunityDTO getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(OpportunityDTO opportunity) {
		this.opportunity = opportunity;
	}

	public ProductDTO getOpportunityProduct() {
		return opportunityProduct;
	}

	public void setOpportunityProduct(ProductDTO opportunityProduct) {
		this.opportunityProduct = opportunityProduct;
	}

	public boolean isSwgServiceAssetIncluded() {
		return swgServiceAssetIncluded;
	}

	public void setSwgServiceAssetIncluded(boolean swgServiceAssetIncluded) {
		this.swgServiceAssetIncluded = swgServiceAssetIncluded;
	}

	public String getSwgServiceAssetName() {
		return swgServiceAssetName;
	}

	public void setSwgServiceAssetName(String swgServiceAssetName) {
		this.swgServiceAssetName = swgServiceAssetName;
	}

	public String getSwgServiceAssetVersion() {
		return swgServiceAssetVersion;
	}

	public void setSwgServiceAssetVersion(String swgServiceAssetVersion) {
		this.swgServiceAssetVersion = swgServiceAssetVersion;
	}

	public String getSwgServiceAssetId() {
		return swgServiceAssetId;
	}

	public void setSwgServiceAssetId(String swgServiceAssetId) {
		this.swgServiceAssetId = swgServiceAssetId;
	}

	public String getStgServiceName() {
		return stgServiceName;
	}

	public void setStgServiceName(String stgServiceName) {
		this.stgServiceName = stgServiceName;
	}

	public String getStgServiceValue() {
		return stgServiceValue;
	}

	public void setStgServiceValue(String stgServiceValue) {
		this.stgServiceValue = stgServiceValue;
	}

	@Override
	public String toString() {
		return "OpportunityOrder [orderId=" + orderId + ", orderPrice=" + orderPrice + ", opportunity=" + opportunity
				+ ", opportunityProduct=" + opportunityProduct + ", swgServiceAssetIncluded=" + swgServiceAssetIncluded
				+ ", swgServiceAssetName=" + swgServiceAssetName + ", swgServiceAssetVersion=" + swgServiceAssetVersion
				+ ", swgServiceAssetId=" + swgServiceAssetId + ", stgServiceName=" + stgServiceName
				+ ", stgServiceValue=" + stgServiceValue + "]";
	}
	
}
