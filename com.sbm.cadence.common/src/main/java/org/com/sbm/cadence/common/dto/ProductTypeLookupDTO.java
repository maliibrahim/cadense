package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_type_lookup")
public class ProductTypeLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long typeId;
	
	@Column(name = "type", nullable = false)
	private String productType;

	public ProductTypeLookupDTO() {}
	
	public ProductTypeLookupDTO(String productType) {
		super();
		this.productType = productType;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "ProductTypeLookup [typeId=" + typeId + ", productType=" + productType + "]";
	}

}
