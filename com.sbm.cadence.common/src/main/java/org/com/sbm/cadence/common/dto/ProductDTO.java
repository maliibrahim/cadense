package org.com.sbm.cadence.common.dto;

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
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class ProductDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "productType", nullable = true)
	private ProductTypeLookupDTO productType;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category")
	private ProductCategoryLookupDTO productCategory;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "item", nullable = true)
	private ProductItemLookupDTO productItem;
	
	@Column
	private String productKind;
	
//	@OneToMany(mappedBy = "opportunityProduct", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private Set<OpportunityOrderDTO> OpportunityOrders = new HashSet<>();

	public ProductDTO() {}
	
	public ProductDTO(String productKind, ProductTypeLookupDTO productType, ProductCategoryLookupDTO productCategory,
			ProductItemLookupDTO productItem) {
		super();
		this.productType = productType;
		this.productCategory = productCategory;
		this.productItem = productItem;
		this.productKind = productKind;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public ProductTypeLookupDTO getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeLookupDTO productType) {
		this.productType = productType;
	}

	public ProductCategoryLookupDTO getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryLookupDTO productCategory) {
		this.productCategory = productCategory;
	}

	public ProductItemLookupDTO getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItemLookupDTO productItem) {
		this.productItem = productItem;
	}

//	public Set<OpportunityOrderDTO> getOpportunityOrders() {
//		return OpportunityOrders;
//	}
//
//	public void setOpportunityOrders(Set<OpportunityOrderDTO> opportunityOrders) {
//		OpportunityOrders = opportunityOrders;
//	}

	public String getProductKind() {
		return productKind;
	}

	public void setProductKind(String productKind) {
		this.productKind = productKind;
	}

	@Override
	public String toString() {
		return "OpportunityProduct [productId=" + productId + ", productKind=" + productKind + ", productType=" + productType + ", productCategory="
				+ productCategory + ", productItem=" + productItem + "]";
	}	
	
}
