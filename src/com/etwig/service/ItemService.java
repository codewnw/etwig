package com.etwig.service;

import java.util.List;

import com.etwig.model.Item;

public interface ItemService {

	boolean createItemTable();

	int saveItem(Item item);

	int updateItem(Item item);

	int deleteItem(String itemId);

	Item findItem(String itemId);

	List<Item> findItems();
}
