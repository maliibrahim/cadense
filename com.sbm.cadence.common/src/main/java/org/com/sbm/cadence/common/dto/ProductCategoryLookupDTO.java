package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_category_lookup")
public class ProductCategoryLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	
	@Column(name = "category", nullable = false)
	private String category;

	public ProductCategoryLookupDTO() {}
	
	public ProductCategoryLookupDTO(String category) {
		super();
		this.category = category;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "LicenseCategory [categoryId=" + categoryId + ", category=" + category + "]";
	}
}
