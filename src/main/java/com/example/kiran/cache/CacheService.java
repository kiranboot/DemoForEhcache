package com.example.kiran.cache;

import java.util.ArrayList;
import com.example.kiran.util.Util;
import java.util.List;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	@Autowired
	private ItemsRepository itemsRepository;

	@Autowired
	private Util util;

	public List<Items> getItems() {
		try {
			List<Items> itemsList = new ArrayList<Items>();

			itemsRepository.findAll().forEach(itemsList::add);

			if (util.isValidCollection(itemsList)) {
				return itemsList;
			} else {
				System.out.println("Resource not found Ex");
			}
		} catch (DataException dataException) {
			System.out.println("Data Exception occured");
		}
		return null;
	}
	
}
