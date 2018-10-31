package com.etwig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.etwig.dao.util.DbMetaData;
import com.etwig.dao.util.DbUtil;
import com.etwig.model.Customer;
import com.etwig.model.Item;
import com.etwig.util.IdGenerator;

public class ItemDaoImpl implements ItemDao {

	private static final String createItemQuery = "CREATE TABLE ETWIG_ITEM (ID VARCHAR, NAME VARCHAR, DECRIPTION VARCHAR, PRICE DECIMAL, QUANTITY NUMBER, BASE_IMGAE_URL VARCHAR)";
	private static final String selectItemQuery = "SELECT * FROM ETWIG_ITEM WHERE ID = ?";
	private static final String insertItemQuery = "INSERT INTO ETWIG_ITEM VALUES(?, ?, ?, ?, ?, ?)";
	private static final String selectAllItems = "SELECT * FROM ETWIG_ITEM";

	@Override
	public boolean createItemTable() {
		if (!DbMetaData.isTableExists("ETWIG_ITEM")) {
			try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
				System.out.println("Creating table ETWIG_ITEM");
				return !stmt.execute(createItemQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Table ETWIG_ITEM already exists.");
		}
		return false;
	}

	@Override
	public String saveItem(Item item) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(insertItemQuery)) {
			String itemId = IdGenerator.generateItemId();
			pstmt.setString(1, itemId);
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getDescription());
			pstmt.setDouble(4, item.getPrice());
			pstmt.setInt(5, item.getQuantity());
			pstmt.setString(6, item.getBaseImageUrl());

			pstmt.executeUpdate();
			return itemId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public int updateItem(Item item) {
		return 0;
	}

	@Override
	public int deleteItem(String itemId) {
		return 0;
	}

	@Override
	public Item findItem(String itemId) {
		System.out.println(">> " + this.getClass().getSimpleName());
		System.out.println("In " + this.getClass().getSimpleName() + " Item ID: " + itemId);
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(selectItemQuery)) {
			pstmt.setString(1, itemId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Item item = new Item();

				item.setId(rs.getString(1));
				item.setName(rs.getString(2));
				item.setDescription(rs.getString(3));
				item.setPrice(rs.getDouble(4));
				item.setQuantity(rs.getInt(5));
				item.setBaseImageUrl(rs.getString(6));

				return item;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> findItems() {
		List<Item> items = new ArrayList<>();
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(selectAllItems);
			while (rs.next()) {
				Item item = new Item();

				item.setId(rs.getString(1));
				item.setName(rs.getString(2));
				item.setDescription(rs.getString(3));
				item.setPrice(rs.getDouble(4));
				item.setQuantity(rs.getInt(5));
				item.setBaseImageUrl(rs.getString(6));

				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

}
