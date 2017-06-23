package com.example.kiran.util;

import java.util.Collection;

import org.ehcache.Cache;
import org.springframework.stereotype.Component;

@Component
public class Util {

	/**
	 * Checks if collection is NOT null and NOT empty
	 * 
	 * @param Collection
	 * @return boolean result of validation (TRUE if collection contains at
	 *         least one element)
	 */
	public <E> boolean isValidCollection(Collection<E> collection) {

		if (null != collection && !collection.isEmpty()) {
			return true;
		}

		return false;
	}

	/**
	 * * Checks if cache is loaded with at least one element
	 * 
	 * @param cache
	 *            - Cache instance to be checked
	 * @return boolean - True if this instance of cache is initialized and has
	 *         at least one element stored
	 */
	public static <K, V> boolean isCacheLoaded(Cache<K, V> cache) {
		if (null != cache && cache.iterator().hasNext()) {
			return true;
		}
		return false;
	}

}
