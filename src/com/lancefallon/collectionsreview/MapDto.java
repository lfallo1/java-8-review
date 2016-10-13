package com.lancefallon.collectionsreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDto<K,V,T>{

	private final Map<K, V> myMap;
	private final List<T> myList;
	
	public MapDto(Map<K, V> map, List<T> list){
		this.myMap = map;
		this.myList = list;
	}

	public Map<K, V> getMyMap() {
		return new HashMap<>(this.myMap);
	}

	public List<T> getMyList() {
		return new ArrayList<>(this.myList);
	}
	
}
