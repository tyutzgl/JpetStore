  package com.clps.jPet.dao;


import java.util.List;

import com.clps.jPet.pojo.Item;

public interface ItemDao {

	/**
	 * Get all item listings
	 * @return List<Item>
	 */
	List<Item> getItems() ;

	/**
	 * Get all item listings
	 * @return List<Item>
	 */
	List<Item> getItemList() ;
}
