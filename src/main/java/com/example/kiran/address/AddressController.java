package com.example.kiran.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.kiran.cache.ItemsCacheHandler;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping("/address")
	public List<Address> getAllAddress() {
		// return Arrays.asList(new Business("test", "1"), new Business("best",
		// "2"));
		return addressService.getAllAddress();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/address/{id}")
	public Address getAddress(@PathVariable String id) {
		return addressService.getAddress(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/address")
	public void addAddress(@RequestBody Address business) {
		addressService.addAddress(business);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/address/{id}")
	public void updateAddress(@RequestBody Address business, @PathVariable String id) {
		addressService.updateAddress(id, business);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/address/{id}")
	public void deleteAddress(@PathVariable String id) {
		addressService.deleteAddress(id);
	}

}
