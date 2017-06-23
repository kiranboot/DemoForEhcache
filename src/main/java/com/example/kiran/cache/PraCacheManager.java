package com.example.kiran.cache;

import java.net.URL;

import javax.annotation.PreDestroy;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.stereotype.Component;

@Component
public class PraCacheManager {

	private CacheManager cacheManager;

	private PraCacheManager() {
		URL xmlLocation = getClass().getResource("/ehCache.xml");
		Configuration xmlConfig = new XmlConfiguration(xmlLocation);
		cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
		cacheManager.init();
	}

	@PreDestroy
	private void closeCache() {
		if (null != cacheManager) {
			cacheManager.close();
		}
	}

	protected <K, V> Cache<K, V> initializeCache(String cacheName, Class<K> keyType, Class<V> valueType) {
		return cacheManager.getCache(cacheName, keyType, valueType);
	}

}
