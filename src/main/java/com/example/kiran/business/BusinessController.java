package com.example.kiran.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.kiran.cache.ItemsCacheHandler;

@RestController
public class BusinessController {

	@Autowired
	private BusinessService businessService;
	
	@Autowired
	private ItemsCacheHandler itemsCacheHandler;

	@RequestMapping("/businesses")
	public List<Business> getAllBusiness() {
		// return Arrays.asList(new Business("test", "1"), new Business("best",
		// "2"));
		System.out.println(itemsCacheHandler.getItemName(1));
		System.out.println(itemsCacheHandler.getItemName(2));
		return businessService.getAllBusiness();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/business/{id}")
	public Business getBusiness(@PathVariable String id) {
		return businessService.getBusiness(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/business")
	public void addBusiness(@RequestBody Business business) {
		businessService.addBusiness(business);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/business/{id}")
	public void updateBusiness(@RequestBody Business business, @PathVariable String id) {
		businessService.updateBusiness(id, business);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/business/{id}")
	public void deleteBusiness(@PathVariable String id) {
		businessService.deleteBusiness(id);
	}

}
