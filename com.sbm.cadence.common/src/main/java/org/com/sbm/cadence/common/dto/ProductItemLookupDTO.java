package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_item_lookup")
public class ProductItemLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}


	@Column(name = "item", nullable = false)
	private String item;

	public ProductItemLookupDTO() {}
	
	public ProductItemLookupDTO(String item) {
		super();
		this.item = item;
	}

	@Override
	public String toString() {
		return "ProductItemLookup [itemId=" + itemId + ", item=" + item + "]";
	}	
}
