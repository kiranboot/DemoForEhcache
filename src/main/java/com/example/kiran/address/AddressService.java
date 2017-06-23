package com.example.kiran.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> getAllAddress() {
		List<Address> businessList = new ArrayList<>();
		//businessRepository.findAll();
		addressRepository.findAll().forEach(businessList::add);
		return businessList;
	}

	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	public Address getAddress(String id) {
		return addressRepository.findOne(id);
	}
	
	public void updateAddress(String id, Address address) {
		 addressRepository.save(address);
	}

	public void deleteAddress(String id) {
		 addressRepository.delete(id);
	}

	public void addAllAddress(List<Address> addList) {
		//call addressRepository.save(address); this in loop
	}
}
