package com.example.kiran.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kiran.address.Address;
import com.example.kiran.address.AddressRepository;
import com.example.kiran.address.AddressService;

@Service
public class BusinessService {

	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressService addressService;

	public List<Business> getAllBusiness() {
		List<Business> businessList = new ArrayList<>();
		//businessRepository.findAll();
		businessRepository.findAll().forEach(businessList::add);
		return businessList;
	}

	public void addBusiness(Business business) {
		//call 
		addressService.addAllAddress(new ArrayList<Address>());
		businessRepository.save(business);
	}
	
	public Business getBusiness(String id) {
		Business b = businessRepository.findOne(id);
		//List<Address> addressList = addressRepository.findByBusinessId(id);
		return b;
	}
	
	public void updateBusiness(String id, Business business) {
		 businessRepository.save(business);
	}

	public void deleteBusiness(String id) {
		 businessRepository.delete(id);
	}
}
