package com.example.kiran.address;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {


	@Id
	private String addressId;
	private String city;
	private String state;
	private String businessId;
	
	public Address() {
	}


	public String getAddressId() {
		return addressId;
	}


	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}


	public String getBusinessId() {
		return businessId;
	}


	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	


}
