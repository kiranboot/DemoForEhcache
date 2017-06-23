package com.example.kiran.cache;

import com.example.kiran.util.Util;

import org.apache.commons.lang3.StringUtils;
import org.ehcache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ehcache.Cache.Entry;

import java.util.*;

@Component
public class ItemsCacheHandler {

	private Cache<Integer, String> itemsCache;

	@Autowired
	private PraCacheManager praCacheManager;

	@Autowired
	private CacheService cacheService;

	private void initializeCache() {
		itemsCache = praCacheManager.initializeCache("itemsCache", Integer.class, String.class);
	}

	private void refreshCache() {
		if (null == itemsCache) {
			initializeCache();
		}
		itemsCache.clear();
		List<Items> itemsList = cacheService.getItems();
		itemsList.forEach(item -> {
			if (null != item) {
				itemsCache.put(Integer.valueOf(item.getItemId()), item.getItemName());
			}
		});
	}

	public String getItemName(int itemld) {
		if (!Util.isCacheLoaded(itemsCache)) {
			refreshCache();
		}
		return itemsCache.get(itemld);
	}

	public int getItemld(String itemName) {
		int itemld = 0;
		if (StringUtils.isNotBlank(itemName)) {
			if (!Util.isCacheLoaded(itemsCache)) {
				refreshCache();
			}

			for (Entry<Integer, String> items : itemsCache) {
				if (itemName.equalsIgnoreCase(items.getValue())) {
					itemld = items.getKey();
					break;
				}
			}
		}

		if (0 != itemld) {
			return itemld;
		} else {
			// TODD: Do NOT return anything. Throw exception here.
			return 0;
		}
	}

}
