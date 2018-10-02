package com.etwig.dao;

import java.util.List;

import com.etwig.model.Item;

public class ItemDaoImpl implements ItemDao {

	@Override
	public boolean createItemTable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveItem(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItem(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(String itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item findItem(String itemId) {
		System.out.println("In " + this.getClass().getSimpleName());
		System.out.println("Running JDBC Inser command");
		return null;
	}

	@Override
	public List<Item> findItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
