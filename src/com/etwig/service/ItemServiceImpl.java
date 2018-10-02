package com.etwig.service;

import java.util.List;

import com.etwig.dao.ItemDao;
import com.etwig.dao.ItemDaoImpl;
import com.etwig.model.Item;

public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;
	
	public ItemServiceImpl() {
		super();
		this.itemDao = new ItemDaoImpl();
	}

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
		return itemDao.findItem(itemId);
	}

	@Override
	public List<Item> findItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
