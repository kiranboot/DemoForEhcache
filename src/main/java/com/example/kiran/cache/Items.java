package com.example.kiran.cache;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Items {

	@Id
	private String itemId;
	private String itemName;
	private String itemDesc;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

}
