package com.etwig.dao;

import java.util.List;

import com.etwig.model.Item;

public interface ItemDao {

	boolean createItemTable();

	String saveItem(Item item);

	int updateItem(Item item);

	int deleteItem(String itemId);

	Item findItem(String itemId);

	List<Item> findItems();
}
